package com.example.refuse.result;

import com.example.refuse.vo.CityAbroad;
import com.example.refuse.vo.CityInternal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月23日 8:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityIntroResult {
    private Integer code;
    private String msg;
    private CityInternal cityInternal;
    private CityAbroad cityAbroad;
}
