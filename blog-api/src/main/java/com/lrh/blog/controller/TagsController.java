package com.lrh.blog.controller;


import com.lrh.blog.service.TagService;
import com.lrh.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
public class TagsController {
    @Autowired
    private TagService tagService;
    //路径
    @GetMapping("hot")

    public Result hot () {
        int limit = 6;
        return tagService.hots(limit);
    }

    @GetMapping("")

    public Result findAll () {
        return tagService.findAll();
    }

    @GetMapping("detail")

    public Result findAllDetail () {
        return tagService.findAllDetail();
    }
    @GetMapping("detail/{id}")

    public Result findAllDetailById (@PathVariable("id") Long id) {
        return tagService.findAllDetailById(id);
    }

}
