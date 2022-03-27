package com.example.refuse.result;

import com.example.refuse.vo.GoodsDet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月27日 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDetResult {
    private Integer code;
    private String msg;
    private GoodsDet data;
}
