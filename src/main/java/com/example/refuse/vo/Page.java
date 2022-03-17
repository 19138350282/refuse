package com.example.refuse.vo;

import com.example.refuse.entity.RefuseInfo;
import lombok.*;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月16日 8:06
 */
@Data
public class Page<T> {
    private Integer total;
    private Integer pagenum;
    private List<T> data;
}
