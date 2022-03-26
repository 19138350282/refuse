package com.example.refuse.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.refuse.entity.User;
import com.example.refuse.mapper.UserMapper;
import com.example.refuse.request.UserRequest;
import com.example.refuse.result.GlobalResult;
import com.example.refuse.util.WeChatUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /**
     * 微信用户登录详情
     */
    @PostMapping("/login")
    public GlobalResult user_login(@RequestBody UserRequest userRequest)
    {
        if(userRequest==null){
            return GlobalResult.build(1000,"传入对象为空",null);
        }
        // 用户非敏感信息：rawData
        // 签名：signature
        JSONObject rawDataJson = JSON.parseObject(userRequest.getRawData());
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        JSONObject SessionKeyOpenId = WeChatUtil.getSessionKeyOrOpenId(userRequest.getCode());
        // 3.接收微信接口服务 获取返回的参数
        String openid = SessionKeyOpenId.getString("openid");
        if(openid==null||openid.equals(""))
        {
            return GlobalResult.build(1001,"获取不到openid",openid);
        }
        String sessionKey = SessionKeyOpenId.getString("session_key");
        if(sessionKey==null||sessionKey.equals(""))
        {
            return GlobalResult.build(1002,"获取不到sessionKey",sessionKey);
        }
        //  4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(userRequest.getRawData() + sessionKey);
        if (!signature2.equals(userRequest.getSignature())) {
           return GlobalResult.build(5000, "签名校验失败", SessionKeyOpenId);
        }
        // 5.根据返回的User实体类，判断用户是否是新用户，是的话，将用户信息存到数据库；不是的话，更新最新登录时间
        User user = this.userMapper.queryById(openid);
        // uuid生成唯一key，用于维护微信小程序用户与服务端的会话
        String skey = UUID.randomUUID().toString();
        if (user == null) {
            // 用户信息入库
            String nickName = rawDataJson.getString("nickName");
            String avatarUrl = rawDataJson.getString("avatarUrl");
            String gender = rawDataJson.getString("gender");
            String city = rawDataJson.getString("city");
            String country = rawDataJson.getString("country");
            String province = rawDataJson.getString("province");

            user = new User();
            user.setOpenid(openid);
            user.setSkey(skey);
            user.setCreateTime(new Date());
            user.setLastVisitTime(new Date());
            user.setSessionKey(sessionKey);
            user.setCity(city);
            user.setProvince(province);
            user.setCountry(country);
            user.setAvatarUrl(avatarUrl);
            user.setGender(Integer.parseInt(gender));
            user.setNickName(nickName);

            this.userMapper.insert(user);
        } else {
            // 已存在，更新用户登录时间
            user.setLastVisitTime(new Date());
            // 重新设置会话skey
            user.setSkey(skey);
            this.userMapper.updateUser(user);
        }
        //encrypteData比rowData多了appid和openid
        JSONObject userInfo = new JSONObject();
        if(userRequest.getEncrypteData()==null){
            return GlobalResult.build(1100, "encrypteDate为空", null);
        }
        if(userRequest.getIv()==null){
            return GlobalResult.build(1100, "iv为空", null);
        }
        userInfo = WeChatUtil.getUserInfo(userRequest.getEncrypteData(), sessionKey, userRequest.getIv());
        if(userInfo==null){
            return GlobalResult.build(1100, "userInfo为空", null);
        }
        //6. 把新的skey返回给小程序
        GlobalResult result = GlobalResult.build(2000, null, skey);
        return result;
    }
}
