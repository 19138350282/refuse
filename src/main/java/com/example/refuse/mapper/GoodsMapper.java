package com.example.refuse.mapper;

import com.example.refuse.vo.Details;
import com.example.refuse.vo.GoodsInfo;
import com.example.refuse.vo.Rotation;
import com.example.refuse.vo.Toppic;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface GoodsMapper {
    int getTotal();
    List<GoodsInfo> findByPage(Integer pagesize, Integer offset);
    String findName(Integer goods_id);
    List<Rotation> findRotation(Integer goods_id);
    Integer findScore(Integer goods_id);
    Integer findNumber(Integer goods_id);
    Date findDeadtime(Integer goods_id);
    List<Details> findDetails(Integer goods_id);
    List<Toppic> findToppic();
}
