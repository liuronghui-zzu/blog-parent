package com.lrh.blog.service;

import com.lrh.blog.vo.Result;
import com.lrh.blog.vo.TagVo;

import java.util.List;

public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(Long id);

}
