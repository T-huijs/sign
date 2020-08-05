package com.hui.service;

import java.util.List;

public interface ResourceService {


    /**
     * 查询指定角色可访问的接口
     * @param roleNo
     * @return
     */
    List<String> queryUrl(String roleNo);

    /**
     * 校验角色是否拥有访问权限
     * @param roleNo
     * @param url
     * @return
     */
    Boolean checkRole(String roleNo, String url);
}
