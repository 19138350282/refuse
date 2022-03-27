package com.example.refuse.result;

import com.example.refuse.vo.Toppic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月27日 23:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsToppicResult {
    private Integer code;
    private String msg;
    private List<Toppic> data;
}
