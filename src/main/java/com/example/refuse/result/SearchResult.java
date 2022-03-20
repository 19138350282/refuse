package com.example.refuse.result;

import com.example.refuse.vo.SearchInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月20日 14:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {
    private Integer code;
    private String msg;
    private List<SearchInfo> data = new ArrayList();
}
