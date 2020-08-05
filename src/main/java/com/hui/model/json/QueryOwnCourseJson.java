package com.hui.model.json;

import com.hui.model.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class QueryOwnCourseJson {

    private List<Course> courseList;



}
