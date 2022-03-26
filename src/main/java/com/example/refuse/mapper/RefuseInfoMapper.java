package com.example.refuse.mapper;

import com.example.refuse.entity.RefuseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RefuseInfoMapper {

    int getTotal(Integer catenum);

    List<RefuseInfo> findByPage(Integer catenum, Integer pagesize, Integer offset);

    List<RefuseInfo> searchRefuse(String name);
}
