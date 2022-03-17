package com.example.refuse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月13日 15:51
 */
@Setter
@Getter
@AllArgsConstructor
public class RefuseInfo{
    private String refusename;
    private String refusecate;
    private Integer catenum;

    public RefuseInfo(){}
}
