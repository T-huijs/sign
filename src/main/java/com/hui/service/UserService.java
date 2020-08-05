package com.hui.service;


import com.hui.model.form.LoginForm;
import com.hui.model.form.RegisterForm;
import com.hui.model.json.LoginJson;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    /**
     * 注册
     * @param registerForm
     * @return
     */
    Boolean register(RegisterForm registerForm);

    /**
     * 账号密码登录
     * @param loginForm
     * @return
     */
    LoginJson login(LoginForm loginForm, HttpServletRequest request);


    /**
     * 从session获取用户编号
     * @param request
     * @return
     */
    String getUserNo(HttpServletRequest request);

    /**
     * 从session获取用户角色编号
     * @param request
     * @return
     */
    String getRoleId(HttpServletRequest request);

    /**
     * 注销
     * @param request
     * @return
     */
    Boolean quit(HttpServletRequest request);

}
