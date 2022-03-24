package com.example.refuse.mapper;

import com.example.refuse.entity.News;
import com.example.refuse.vo.NewsDet;
import com.example.refuse.vo.NewsReco;
import com.example.refuse.vo.NewsTopic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {
    List<NewsReco> recoByPage();

    NewsDet findNews(Integer id);

    void addVisit(Integer id);

    List<NewsTopic> topicByPage();
}
