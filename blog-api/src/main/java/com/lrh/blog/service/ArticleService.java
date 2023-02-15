package com.lrh.blog.service;

import com.lrh.blog.vo.Result;
import com.lrh.blog.vo.params.ArticleParam;
import com.lrh.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ArticleService {

    Result listArticle(PageParams pageParams);

    //最热文章
    Result hotArticle(int limit);

    //最新文章
    Result newArticles(int limit);

    //文章归档
    Result listArchives();

    //查看文章详情
    Result findArticleById(Long articleId);


    Result publish(ArticleParam articleParam);
}
