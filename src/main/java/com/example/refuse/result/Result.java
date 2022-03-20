package com.example.refuse.result;

import com.example.refuse.vo.param.AnswerVo;
import com.example.refuse.vo.param.QuestionVo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = 4633451373316892528L;

    // 响应业务状态
    //private boolean success;

    private int code;

    // 响应消息
    private String msg ;

    // 响应数据
//    private Object title ;
//
//    private Object answer ;
    private List<QuestionVo> title = new ArrayList<QuestionVo>();
    private List<AnswerVo> answer = new ArrayList<AnswerVo>();

    public static Result success(List<QuestionVo> data1 , List<AnswerVo> data2){
        return new Result(200,"success",data1,data2);
    }

    public static Result fail(int code, String msg){
        return new Result(code,msg,null,null);
    }

}