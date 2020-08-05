package com.hui.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper {

    /**d
     * 查询角色可访问的接口路径；
     * @param roleId
     * @return
     */
    List<String> queryUrl(String roleId);
}
