package com.hui.model.form;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Data
public class RegisterForm {

    //账号
    @NotBlank(message = "账号不能为空或''")
    private String account;

    //密码
    @NotBlank(message = "密码不能为空或''")
    private String password;

    //学生学号/老师编号
    @NotBlank(message = "密码不能为空或''")
    private String userNo;
    //角色编号
    @NotBlank(message = "密码不能为空或''")
    private String roleId;

}
