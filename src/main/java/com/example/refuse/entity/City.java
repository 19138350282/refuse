package com.example.refuse.entity;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月23日 8:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Integer id;
    private Integer num;
    private String location;
    private String picture;
    private String cityname;
    private String acttime;
    private String rules;
    private String measures;
}
