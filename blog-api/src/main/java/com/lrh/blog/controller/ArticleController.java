package com.lrh.blog.controller;


import com.lrh.blog.common.aop.LogAnnotation;
import com.lrh.blog.common.cache.Cache;
import com.lrh.blog.service.ArticleService;
import com.lrh.blog.vo.Result;
import com.lrh.blog.vo.params.ArticleParam;
import com.lrh.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("articles")
public class ArticleController {

    /**
     * 首页文章列表
     * @param pageParams
     * @return
     */
    @Autowired
    private ArticleService articleService;

    @PostMapping
//    @Cache(expire = 5 * 60 * 1000,name = "listArticle")
    @LogAnnotation(module="文章",operator ="获取文章列表")
    public Result listArticle(@RequestBody PageParams pageParams) {

        return  articleService.listArticle(pageParams);
    }
    @PostMapping("hot")
//    @Cache(expire = 5 * 60 * 1000,name = "hotArticle")
    public Result hotArticle() {
        int limit = 5;
        return  articleService.hotArticle(limit);
    }
    @PostMapping("new")
//    @Cache(expire = 5 * 60 * 1000,name = "newArticles")
    public Result newArticles() {
        int limit = 5;
        return  articleService.newArticles(limit);
    }

    @PostMapping("listArchives")
    public Result listArchives() {
        return  articleService.listArchives();
    }
    @PostMapping("view/{id}")
    public Result findArticleById (@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    //post
    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }



//    @PostMapping
//
//    @LogAnnotation(module="文章",operator ="获取文章列表")
//    public  Result listArticle(@RequestBody PageParams pageParams) {
//        return  articleService.listArticle(pageParams);
//    }

}
