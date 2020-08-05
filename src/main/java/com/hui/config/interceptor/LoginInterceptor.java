package com.hui.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import com.hui.common.ReturnJson;
import com.hui.model.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器-校验是否登录
 */

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws BusinessException {

        log.info("登录拦截：" + request.getRequestURI());
        // 判断当前用户是否已经登陆
        HttpSession session = request.getSession(false);

        if(null == session){
            throw new BusinessException(CommonErrorCode.NO_LOGIN);
        }
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if(null == userInfo){
            throw new BusinessException(CommonErrorCode.NO_LOGIN);
        }
        log.info("登录拦截器从session获取用户信息:userInfo-{}", userInfo.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LoginInterceptor postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("LoginInterceptor afterCompletion ---");
    }


}
