package com.lrh.blog.controller;

import com.lrh.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

        @RequestMapping("test")
        public Result test(){
            return Result.success(null);
        }
    }

