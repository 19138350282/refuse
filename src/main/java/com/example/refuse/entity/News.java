package com.example.refuse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月21日 17:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private Integer id;
    private String picture;
    private String title;
    private String writer;
    private Date time;
    private String content;
    private Integer visitnum;
}
