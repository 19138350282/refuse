package com.example.refuse.mapper;

import com.example.refuse.vo.CityChild;
import com.example.refuse.vo.CityDet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {

    List<CityChild> findInternal();

    List<CityChild> findAbroad();

    CityDet findById(String id);
}
