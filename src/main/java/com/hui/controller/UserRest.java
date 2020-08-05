package com.hui.controller;

import com.hui.common.BusinessException;
import com.hui.common.ReturnJson;
import com.hui.model.form.LoginForm;
import com.hui.model.form.RegisterForm;
import com.hui.model.json.LoginJson;
import com.hui.service.UserService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Api(value = "用户相关功能")
@Slf4j
@RequestMapping("/user")
@RestController
public class UserRest {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation(value="注册", notes="注册", response = Boolean.class)
    public ReturnJson register(RegisterForm registerForm){
        return ReturnJson.success(userService.register(registerForm));
    }

    @PostMapping("/login")
    @ApiOperation(value="账号密码登录", notes="账号密码登录", response = LoginJson.class)
    public ReturnJson login(@Validated LoginForm accountLoginForm, HttpServletRequest request) throws BusinessException {
        return ReturnJson.success(userService.login(accountLoginForm,request));
    }

    @PostMapping("/quit")
    @ApiOperation(value="退出", notes="退出", response = Boolean.class)
    public ReturnJson quit(HttpServletRequest request){
        return ReturnJson.success(userService.quit(request));
    }


}
