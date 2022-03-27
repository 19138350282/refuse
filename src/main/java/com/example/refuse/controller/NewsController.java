package com.example.refuse.controller;

import com.example.refuse.mapper.NewsMapper;
import com.example.refuse.result.NewsDetResult;
import com.example.refuse.result.NewsRecoResult;
import com.example.refuse.result.TopicRecoResult;
import com.example.refuse.vo.NewsDet;
import com.example.refuse.vo.NewsReco;
import com.example.refuse.vo.NewsTopic;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年03月21日 17:24
 */
@RestController
public class NewsController {
    @Autowired
    NewsMapper newsMapper;

    @GetMapping("/news")
    public NewsRecoResult recoNews(){
        List<NewsReco> list = newsMapper.recoByPage();
        if(list.size()!=0){
            return new NewsRecoResult(2000,"查找成功",list);
        }else{
            return new NewsRecoResult(1100,"查找失败",null);
        }
    }

    @GetMapping("/news/detail")
    public NewsDetResult detNews(@Param("news_id")Integer news_id){
        if(news_id<=0){
            return new NewsDetResult(1000,"参数错误",null);
        }
        newsMapper.addVisit(news_id);
        NewsDet newsDet = newsMapper.findNews(news_id);
        if(newsDet!=null){
            return new NewsDetResult(2000,"查找成功",newsDet);
        }else{
            return new NewsDetResult(1100,"未找到相关新闻信息",null);
        }
    }

    @GetMapping("/newstopic")
    public TopicRecoResult topicReco(){
        List<NewsTopic> list = newsMapper.topicByPage();
        if(list.size()!=0){
            return new TopicRecoResult(2000,"查找成功",list);
        }else{
            return new TopicRecoResult(1100,"查找失败",null);
        }
    }
}
