package com.lrh.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lrh.blog.dao.mapper.ArticleMapper;
import com.lrh.blog.dao.pojo.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
 @Component
 public class ThreadService {


        @Async("taskExecutor")

   public void updateViewCount(ArticleMapper articleMapper, Article article){

            int viewCounts = article.getViewCounts();
            Article  articleUpdate = new Article();
            articleUpdate.setViewCounts(article.getViewCounts() + 1);
            LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Article::getId,article.getId());
            queryWrapper.eq(Article::getViewCounts,viewCounts);
            articleMapper.update(articleUpdate,queryWrapper);
            try {
                //睡眠5秒 证明不会影响主线程的使用
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
 }



