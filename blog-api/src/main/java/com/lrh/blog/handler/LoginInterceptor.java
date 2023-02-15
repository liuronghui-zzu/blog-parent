package com.lrh.blog.handler;


import com.alibaba.fastjson.JSON;
import com.lrh.blog.dao.pojo.SysUser;
import com.lrh.blog.service.LoginService;
import com.lrh.blog.utils.JWTUtils;
import com.lrh.blog.utils.UserThreadLocal;
import com.lrh.blog.vo.ErrorCode;
import com.lrh.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    private JWTUtils jwtUtils;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        // 判断请求接口路径 是否为HandlerMethod (controller）方法
        //判断token是否为空，如果为空 则为未登录
        // 如果token不为空 登录验证 loginService check Token
        // 认证成功 放行
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("Authorization");
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");
        if (token == null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        Map<String, Object> map = JWTUtils.checkToken(token);
        if (map == null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //是登录状态，放行
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        UserThreadLocal.put(sysUser);
        return  true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //防止内存泄漏
        UserThreadLocal.remove();
    }
}
