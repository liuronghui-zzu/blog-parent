package com.lrh.blog.service;


import com.lrh.blog.vo.Result;
import com.lrh.blog.vo.params.LoginParam;

public interface LoginService {


    Result login(LoginParam loginParam);

    Result logout(String token);

    Result register(LoginParam loginParam);
}
