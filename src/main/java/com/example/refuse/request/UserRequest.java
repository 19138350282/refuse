package com.example.refuse.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月26日 14:31
 */
@Data
@AllArgsConstructor
public class UserRequest {
    private String code;
    private String rawData;
    private String signature;
    private String encrypteData;
    private String iv;
}
