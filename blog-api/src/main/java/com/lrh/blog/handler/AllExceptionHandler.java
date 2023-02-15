package com.lrh.blog.handler;


import com.lrh.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllExceptionHandler {
    //进行异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception exception) {
        exception.printStackTrace();

        return  Result.fail(-999,"系统异常");

    }
}
