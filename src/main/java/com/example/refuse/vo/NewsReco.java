package com.example.refuse.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月22日 15:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsReco {
    private Integer id;
    private String picture;
    private String title;
    private Integer visitnum;
    private Date time;
}
