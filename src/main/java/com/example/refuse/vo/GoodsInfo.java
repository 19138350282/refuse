package com.example.refuse.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月27日 22:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsInfo {
    private Integer id;
    private String name;
    private Integer score;
    private Date deadtime;
    private String thumbnail;
}
