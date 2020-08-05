package com.hui.model.entity;

import com.hui.model.Entity;
import lombok.*;


@Data
public class User extends Entity {

    private String account;

    private String password;

    private String userNo;

    private String roleId;

    private String isUse;

}
