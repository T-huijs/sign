package com.hui.model.entity;


import com.hui.model.Entity;
import lombok.Data;

@Data
public class Student extends Entity {

    private String studentNo;

    private String name;

    private String sex;

    private Integer age;

    private String telPhone;

    private String classNo;


}
