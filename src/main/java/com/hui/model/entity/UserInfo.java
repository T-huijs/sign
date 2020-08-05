package com.hui.model.entity;


import lombok.Data;
import lombok.ToString;

/**
 * 需要缓存的用户信息
 */
@ToString
@Data
public class UserInfo {

    private String userNo;

    private String roleId;

}
