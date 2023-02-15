package com.lrh.blog.controller;

import com.lrh.blog.service.CategoryService;
import com.lrh.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result Categories() {

        return  categoryService.findAll();
    }
    @GetMapping("detail")
    public Result cagegoriesDetail() {

        return  categoryService.findAllDetail();
    }
    @GetMapping("detail/{id}")
    public Result cagegoryDetailById(@PathVariable("id") Long id) {


        return  categoryService.cagegoryDetailById(id);
    }
}
