package com.example.refuse.result;

import com.example.refuse.vo.GoodsInfo;
import com.example.refuse.vo.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月27日 21:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsListResult {
    private Integer code;
    private String msg;
    private Page<GoodsInfo> page;
}
