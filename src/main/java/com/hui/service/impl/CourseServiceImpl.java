package com.hui.service.impl;

import com.hui.mapper.CourseMapper;
import com.hui.model.entity.Course;
import com.hui.model.form.BindCourseForm;
import com.hui.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public Boolean addCourse(Course course) {
        return courseMapper.addCourse(course) > 0;
    }

    @Override
    public Boolean updateCourse(Course course) {
        return courseMapper.updateCourse(course) > 0;
    }

    @Override
    public Boolean deleteCourse(String courseNo) {
        return courseMapper.deleteCourse(courseNo) > 0;
    }

    @Override
    public Course queryCourse(String courseNo) {
        return courseMapper.queryCourse(courseNo);
    }

    @Override
    public Boolean bindStudent(BindCourseForm bindCourseForm) {
        return courseMapper.bindStudent(bindCourseForm) > 0;
    }

    @Override
    public List<Course> queryCourseByTeacherNo(String teacherNo) {
        return courseMapper.queryCourseListByTeacherNo(teacherNo);
    }

    public List<Course> queryCourseByStudentNo(String studentNo){
        return courseMapper.queryCourseListByStudentNo(studentNo);
    }

}
