package com.hunter.sso.service;

import com.hunter.sso.domain.origin.SpUser;

/**
 * @author Hunter
 * @date 2020/4/20
 */
public interface LoginService {

    /**
     * 登陆验证
     * @param username 用户名
     * @param password 密码
     * @return userDTO
     */
    SpUser login(String username, String password);
}
