package com.hui.service;

import com.hui.model.entity.Course;
import com.hui.model.form.BindCourseForm;

import java.util.List;

public interface CourseService {


    /**
     * 插入
     * @param course
     * @return
     */
    Boolean addCourse(Course course);

    /**
     * 修改
     * @param course
     * @return
     */
    Boolean updateCourse(Course course);

    /**
     * 删除
     * @param courseNo
     * @return
     */
    Boolean deleteCourse(String courseNo);

    /**
     * 查询
     * @param courseNo
     * @return
     */
    Course queryCourse(String courseNo);

    /**
     * 学生选课
     * @param bindCourseForm
     * @return
     */
    Boolean bindStudent(BindCourseForm bindCourseForm);

    /**
     * 查询指定老师名下的课程信息
     * @param teacherNo
     * @return
     */
    List<Course> queryCourseByTeacherNo(String teacherNo);

    /**
     * 查询学生名下课程
     * @param studentNo
     * @return
     */
    List<Course> queryCourseByStudentNo(String studentNo);

}
