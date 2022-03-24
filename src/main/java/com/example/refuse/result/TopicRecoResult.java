package com.example.refuse.result;

import com.example.refuse.vo.NewsTopic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月22日 16:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicRecoResult {
    private Integer code;
    private String msg;
    private List<NewsTopic> data = new ArrayList();
}
