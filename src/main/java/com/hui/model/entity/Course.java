package com.hui.model.entity;

import com.hui.model.Entity;
import lombok.Data;

import java.util.Date;

@Data
public class Course extends Entity {

    private String courseNo;

    private String courseName;

    private String courseDesc;

    private String teacherNo;

    private Date upTime;

    private Date downTime;


}
