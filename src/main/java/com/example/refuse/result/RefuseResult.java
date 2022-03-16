package com.example.refuse.result;

import com.example.refuse.entity.RefuseInfo;
import com.example.refuse.vo.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月14日 16:52
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefuseResult {
    private Integer code;
    private String msg;
    private Page<RefuseInfo> page;
}
