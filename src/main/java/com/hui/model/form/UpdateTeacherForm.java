package com.hui.model.form;

import lombok.Data;

@Data
public class UpdateTeacherForm {

    private String teacherNo;

    private String name;

    private String sex;

    private Integer age;

    private String telPhone;

    private String email;

    private String updateBy;

}
