package com.example.refuse.result;

import com.example.refuse.vo.NewsDet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月22日 15:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDetResult {
    private Integer code;
    private String msg;
    private NewsDet data;
}
