package com.hui.model.form.course;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateCourseForm {

    private String courseNo;

    private String courseName;

    private String courseDesc;

    private String teacherNo;

    private Date upTime;

    private Date downTime;
}
