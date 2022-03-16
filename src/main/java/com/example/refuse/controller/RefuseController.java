package com.example.refuse.controller;

import com.example.refuse.entity.RefuseInfo;
import com.example.refuse.mapper.RefuseInfoMapper;
import com.example.refuse.result.RefuseResult;
import com.example.refuse.vo.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月13日 15:53
 */
@RestController
public class RefuseController {
    @Autowired
    RefuseInfoMapper refuseInfoMapper;

    @GetMapping("/recyclable")
    public RefuseResult recyclable(@Param("refuse_id") Integer refuse_id, @Param("pagesize") Integer pagesize, @Param("pagenum") Integer pagenum){
        String pageNum = Integer.toString(pagenum+1);
        List<RefuseInfo> list = refuseInfoMapper.findByPage(refuse_id,pagesize,(pagenum-1)*pagesize);
        Page<RefuseInfo> page=new Page<>();
        page.setData(list);
        int total = refuseInfoMapper.getTotal(refuse_id);
        page.setTotal(total);
        page.setPagenum(pageNum);
        if(list.size()==0){
            return new RefuseResult(1,"未找到相关信息",null);
        }else{
            return new RefuseResult(0,null,page);
        }
    }

}
