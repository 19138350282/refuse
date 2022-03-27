package com.example.refuse.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月27日 22:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDet {
    private String name;
    private List<Rotation> rotation;
    private Integer score;
    private Integer number;
    private Date deadtime;
    private List<Details> details;
}
