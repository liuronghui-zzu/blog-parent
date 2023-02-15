package com.lrh.blog.service;

import com.lrh.blog.dao.pojo.SysUser;
import com.lrh.blog.vo.Result;
import com.lrh.blog.vo.UserVo;

public interface SysUserService {

    SysUser findUserById(Long id);

    UserVo findUserVoById(Long id);

    SysUser findUser(String account, String pwd);

    Result getUserInfoByToken(String token);

    SysUser findUserByAccount(String account);

    void save(SysUser sysUser);


}
