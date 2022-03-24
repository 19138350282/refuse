package com.example.refuse.result;

import com.example.refuse.vo.CityDet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月24日 22:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDetResult {
    private Integer code;
    private String msg;
    private CityDet cityDet;
}
