package com.hui.config.interceptor;

import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import com.hui.service.ResourceService;
import com.hui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 资源鉴权拦截器
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private ResourceService resourceService;

    @Resource
    private UserService userService;

    @Value("${server.servlet.context-path}")
    private String proUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws BusinessException {
        String uri = request.getRequestURI();
        String roleId = userService.getRoleId(request);
        String userNo = userService.getUserNo(request);

        log.info("资源拦截器：访问接口-{}，userNo-{}, roleId-{}", uri, userNo, roleId);
        log.info("proUrl-{}", proUrl);
        String url = uri.substring(proUrl.length());
        log.info("所要访问的接口路径为-{}", url);
        if(!resourceService.checkRole(roleId, url)){
            log.error("当前用户没有接口访问权限：userNo-{}, roleId-{},接口-{}", userNo, roleId, url);
            throw new BusinessException(CommonErrorCode.ROLE_NOT_PROFESSION);
        }
        return true;
    }
}
