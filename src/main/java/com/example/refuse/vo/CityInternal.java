package com.example.refuse.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月23日 8:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInternal {
    private Integer num;
    private String location;
    private List<CityChild> list=new ArrayList();
}
