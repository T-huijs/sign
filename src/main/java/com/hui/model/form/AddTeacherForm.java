package com.hui.model.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddTeacherForm {

    @ApiModelProperty(notes = "教师姓名")
    private String name;

    @ApiModelProperty(notes = "性别")
    private String sex;

    private Integer age;

    private String telPhone;

    private String email;

}
