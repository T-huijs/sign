package com.hui.model.json;

import lombok.Data;

import java.util.Date;

@Data
public class QueryCourseJson {

    private String courseNo;

    private String courseName;

    private String courseDesc;

    private String teacherNo;

    private Date upTime;

    private Date downTime;
}
