package com.lrh.blog.service;

import com.lrh.blog.vo.CategoryVo;
import com.lrh.blog.vo.Result;

public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result cagegoryDetailById(Long id);
}
