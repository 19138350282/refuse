package com.example.refuse.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月22日 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDet {
    private String title;
    private String picture;
    private String writer;
    private Date time;
    private String content;
    private Integer visitnum;
}
