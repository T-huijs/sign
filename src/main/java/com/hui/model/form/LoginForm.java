package com.hui.model.form;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Data
public class LoginForm {

    @NotBlank(message = "账号不能为空或''")
    private String account;

    @NotBlank(message = "密码不能为空或''")
    private String password;

    @NotBlank(message = "角色不能为空或''")
    private String roleId;
}
