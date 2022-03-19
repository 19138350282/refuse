package com.example.refuse.mapper;


import com.example.refuse.vo.param.AnswerVo;
import com.example.refuse.vo.param.QuestionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TitleTestMapper {

     List<QuestionVo> getQuestionList(Integer pagesize, Integer offset);

     List<AnswerVo> getAnswerList(Integer pagesize, Integer offset);
}
