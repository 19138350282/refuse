package com.example.refuse.controller;


import com.example.refuse.mapper.TitleTestMapper;
import com.example.refuse.result.Result;
import com.example.refuse.vo.param.AnswerVo;
import com.example.refuse.vo.param.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
/**
 * 测试题目和答案
 *
 * @return
 */
@RestController
public class TitleTestController {

    @Autowired
    private TitleTestMapper titleTestMapper;

    @GetMapping("/test")
    @ResponseBody
    public Result listTitle() {
        Integer pagenum =1, pagesize = 8 , offset;
        Random rand = new Random();
        pagenum = rand.nextInt(2) + 1;
        offset = (pagenum-1)*pagesize;
        List<QuestionVo> questionData = titleTestMapper.getQuestionList(pagesize,offset);
        List<AnswerVo> answerData = titleTestMapper.getAnswerList(pagesize,offset);
        if (questionData== null) {
            return Result.fail(404, null);
        }
        return Result.success(questionData,answerData);
    }
}
