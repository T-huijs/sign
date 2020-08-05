package com.hui.model.entity;

import com.hui.model.Entity;
import lombok.Data;

@Data
public class Teacher extends Entity {

    private String teacherNo;

    private String name;

    private String sex;

    private Integer age;

    private String telPhone;

    private String email;

}
