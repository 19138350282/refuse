package com.example.refuse.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月14日 16:57
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecyclableRequest {
    private int pagesize;
    private int pagenum;
}
