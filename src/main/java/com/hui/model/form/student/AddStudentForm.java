package com.hui.model.form.student;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddStudentForm {

    private String name;

    private String sex;

    private Integer age;

    private String telPhone;

    private String classNo;
}
