package com.example.refuse.controller;

import com.example.refuse.mapper.GoodsMapper;
import com.example.refuse.result.GoodsDetResult;
import com.example.refuse.result.GoodsListResult;
import com.example.refuse.result.GoodsToppicResult;
import com.example.refuse.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月27日 21:49
 */
@RestController
public class GoodsController {
    @Autowired
    GoodsMapper goodsMapper;

    @GetMapping("/goods")
    public GoodsListResult goodsList(@Param("pagesize") Integer pagesize, @Param("pagenum") Integer pagenum){
        if(pagesize==null || pagenum==null){
            return new GoodsListResult(1001,"参数不完整",null);
        }
        if(pagesize<=0 || pagenum<=0){
            return new GoodsListResult(1000,"参数错误",null);
        }

        int total = goodsMapper.getTotal();
        Page<GoodsInfo> page = new Page<>();
        page.setTotal(total);
        page.setPagenum(pagenum);
        List<GoodsInfo> list = goodsMapper.findByPage(pagesize,(pagenum-1)*pagesize);
        page.setData(list);

        if(list.size()!=0){
            return new GoodsListResult(2000,"查找成功",page);
        }else{
            return new GoodsListResult(1100,"没有找到商品信息",null);
        }
    }

    @GetMapping("/goodsdetail")
    public GoodsDetResult goodsDetail(@Param("goods_id") Integer goods_id){
        if(goods_id == null){
            return new GoodsDetResult(1001,"请传入商品id",null);
        }
        if(goods_id<=0){
            return new GoodsDetResult(1000,"参数错误",null);
        }

        GoodsDet goodsDet = new GoodsDet();
        goodsDet.setName(goodsMapper.findName(goods_id));
        List<Rotation> list1=goodsMapper.findRotation(goods_id);
        goodsDet.setRotation(list1);
        goodsDet.setScore(goodsMapper.findScore(goods_id));
        goodsDet.setNumber(goodsMapper.findNumber(goods_id));
        Date date = goodsMapper.findDeadtime(goods_id);
        goodsDet.setDeadtime(date);
        List<Details> list2 = goodsMapper.findDetails(goods_id);
        goodsDet.setDetails(list2);

        if(list1.size()!=0 && list2.size()!=0){
            return new GoodsDetResult(2000,"查找成功",goodsDet);
        } else if(list1.size()==0){
            return new GoodsDetResult(1100,"没有找到轮播图",null);
        }else if(list2.size()==0){
            return new GoodsDetResult(1100,"没有找到详情图",null);
        }else{
            return new GoodsDetResult(1100,"查找失败",null);
        }

    }

    @GetMapping("/shoppic")
    public GoodsToppicResult goodsToppic(){
        List<Toppic> list = goodsMapper.findToppic();

        if(list.size()!=0){
            return new GoodsToppicResult(2000,"查找成功",list);
        }else{
            return new GoodsToppicResult(1100,"没有找到宣传图",null);
        }
    }
}
