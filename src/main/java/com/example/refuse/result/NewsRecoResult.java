package com.example.refuse.result;

import com.example.refuse.entity.News;
import com.example.refuse.vo.NewsReco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月21日 17:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsRecoResult {
    private Integer code;
    private String msg;
    private List<NewsReco> data = new ArrayList();
}
