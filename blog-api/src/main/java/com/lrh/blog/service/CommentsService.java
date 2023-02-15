package com.lrh.blog.service;

import com.lrh.blog.vo.Result;
import com.lrh.blog.vo.params.CommentParam;

public interface CommentsService {
    //根据文章id查询评论列表
    Result commentsByArticleId(Long id);
    Result comment(CommentParam commentParam);
}
