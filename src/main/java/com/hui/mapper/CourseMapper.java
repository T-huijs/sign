package com.hui.mapper;

import com.hui.model.entity.Course;
import com.hui.model.form.BindCourseForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {


    /**
     * 插入
     * @param course
     * @return
     */
    Integer addCourse(Course course);

    /**
     * 修改
     * @param course
     * @return
     */
    Integer updateCourse(Course course);

    /**
     * 删除
     * @param courseNo
     * @return
     */
    Integer deleteCourse(String courseNo);

    /**
     * 查询
     * @param courseNo
     * @return
     */
    Course queryCourse(String courseNo);

    /**
     * 学生与课程建立关系
     * @param bindCourseForm
     * @return
     */
    Integer bindStudent(BindCourseForm bindCourseForm);

    /**
     * 通过教师编号查询课程信息
     * @param teacherNo
     * @return
     */
    List<Course> queryCourseListByTeacherNo(String teacherNo);

    /**
     * 通过学生编号查询课程信息
     * @param studentNo
     * @return
     */
    List<Course> queryCourseListByStudentNo(String studentNo);


}
