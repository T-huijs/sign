package com.hui.service.impl;

import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import com.hui.mapper.UserMapper;
import com.hui.model.entity.User;
import com.hui.model.entity.UserInfo;
import com.hui.model.form.LoginForm;
import com.hui.model.form.RegisterForm;
import com.hui.model.json.LoginJson;
import com.hui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean register(RegisterForm registerForm){
        log.info("当前注册：账号-{},角色-{},编号-{}", registerForm.getAccount(), registerForm.getRoleId(), registerForm.getUserNo());
        if(isExistsAccount(registerForm)){
            throw new BusinessException(CommonErrorCode.ACCOUNT_EXISTS);
        }
        return addUser(registerForm);
    }

    /**
     * 检验账号是否存在
     * @param registerForm
     * @return
     */
    private Boolean isExistsAccount(RegisterForm registerForm){
        return userMapper.queryCountByAccount(registerForm) > 0;
    }

    /**
     * 添加账户
     * @param registerForm
     * @return
     */
    private Boolean addUser(RegisterForm registerForm){
        User user = new User();
        BeanUtils.copyProperties(registerForm, user);
        user.setIsUse("0");
        return userMapper.addUser(user) > 0;
    }

    @Override
    public LoginJson login(LoginForm loginForm, HttpServletRequest request){
        LoginJson loginJson = userMapper.getUserByAccount(loginForm);
        if(null == loginJson){
            throw new BusinessException(CommonErrorCode.ACCOUNT_OR_PWD_ERROR);
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setRoleId(loginJson.getRoleId());
        userInfo.setUserNo(loginJson.getUserNo());
        HttpSession session = request.getSession(true);
        session.setAttribute("userInfo", userInfo);
        return loginJson;
    }

    public String getUserNo(HttpServletRequest request){
        UserInfo userInfo = getUserInfo(request);
        String userNo = userInfo.getUserNo();
        if(StringUtils.isEmpty(userNo)){
            throw new BusinessException(CommonErrorCode.LOGIN_FAILURE);
        }
        return userNo;
    }

    public String getRoleId(HttpServletRequest request){
        UserInfo userInfo = getUserInfo(request);
        String roleId = userInfo.getRoleId();
        if(StringUtils.isEmpty(roleId)){
            throw new BusinessException(CommonErrorCode.LOGIN_FAILURE);
        }
        return roleId;
    }

    public Boolean quit(HttpServletRequest request){
        getUserInfo(request);
        HttpSession session = request.getSession(false);
        session.removeAttribute("userInfo");
        return true;
    }

    private UserInfo getUserInfo(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(null == session){
            throw new BusinessException(CommonErrorCode.LOGIN_FAILURE);
        }
        Object object = session.getAttribute("userInfo");
        if(null == object){
            throw new BusinessException(CommonErrorCode.LOGIN_FAILURE);
        }
        return (UserInfo)object;
    }


}
