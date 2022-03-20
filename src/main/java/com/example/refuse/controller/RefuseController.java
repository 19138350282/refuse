package com.example.refuse.controller;

import com.example.refuse.entity.RefuseInfo;
import com.example.refuse.mapper.RefuseInfoMapper;
import com.example.refuse.result.RefuseResult;
import com.example.refuse.result.SearchResult;
import com.example.refuse.vo.Page;
import com.example.refuse.vo.SearchInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/garbage")
    public RefuseResult recyclable(@Param("refuse_id") Integer refuse_id, @Param("pagesize") Integer pagesize, @Param("pagenum") Integer pagenum){
            if(refuse_id<1 || refuse_id>4 || pagesize<=0 || pagenum<=0){
            return new RefuseResult(1000,"参数错误",null);
            }
            List<RefuseInfo> list = refuseInfoMapper.findByPage(refuse_id,pagesize,(pagenum-1)*pagesize);
            Page<RefuseInfo> page=new Page<>();
            page.setData(list);
            int total = refuseInfoMapper.getTotal(refuse_id);
            page.setTotal(total);
            page.setPagenum(pagenum);

            if(list.size()!=0){
                return new RefuseResult(2000,"查找成功",page);
            }else{
                return new RefuseResult(1100,"查找失败",null);
            }
    }

    @GetMapping("/searchrefuse")
    public SearchResult search(@Param("name") String name){
        if(name==null){
            return new SearchResult(1000,"请输入垃圾名信息",null);
        }
        List<SearchInfo> list = refuseInfoMapper.searchRefuse(name);
        if(list.size()!=0){
            return new SearchResult(2000,"查找成功",list);
        }else{
            return new SearchResult(1100,"未找到相关垃圾数据",null);
        }
    }

}
