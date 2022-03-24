package com.example.refuse.controller;

import com.example.refuse.mapper.CityMapper;
import com.example.refuse.result.CityDetResult;
import com.example.refuse.result.CityIntroResult;
import com.example.refuse.vo.CityAbroad;
import com.example.refuse.vo.CityChild;
import com.example.refuse.vo.CityDet;
import com.example.refuse.vo.CityInternal;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月24日 21:05
 */
@RestController
public class CityController {
    @Autowired
    CityMapper cityMapper;

    @GetMapping("/cityintroduction")
    public CityIntroResult cityintro(){
        List<CityChild> list1 = cityMapper.findInternal();
        List<CityChild> list2 = cityMapper.findAbroad();
        if(list1.size()==0 && list2.size()!=0){
            return new CityIntroResult(1000,"未查找到国内城市信息,国外城市信息查找成功",
                    new CityInternal(1,"国内",null),new CityAbroad(2,"国外",list2));
        }else if(list1.size()!=0 && list2.size()==0){
            return new CityIntroResult(1100,"国内城市信息查找成功,未查找到国外城市信息",
                    new CityInternal(1,"国内",list1),new CityAbroad(2,"国外",null));
        }else if(list1.size()!=0 && list2.size()!=0){
            return new CityIntroResult(2000,"查找成功",
                    new CityInternal(1,"国内",list1),new CityAbroad(2,"国外",list2));
        }else{
            return new CityIntroResult(4000,"查找失败",
                    new CityInternal(1,"国内",null),new CityAbroad(2,"国外",null));
        }
    }

    @GetMapping("/cityintroduction/citydetail")
    public CityDetResult findCityDet(@Param("city_id") String city_id){
        CityDet cityDet = cityMapper.findById(city_id);
        if(cityDet==null){
            return new CityDetResult(1000,"未找到相关城市信息",null);
        }else{
            return new CityDetResult(2000,"查找成功",cityDet);
        }
    }
}
