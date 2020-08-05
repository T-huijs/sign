package com.hui.mapper;

import com.hui.model.entity.Teacher;
import com.hui.model.form.UpdateTeacherForm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    /**
     * 保存教师信息
     * @param teacher
     * @return
     */
    Integer addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @param updateTeacherForm
     * @return
     */
    Integer updateTeacher(UpdateTeacherForm updateTeacherForm);

    /**
     * 根据教师编号删除教师信息
     * @param teacherNo
     * @return
     */
    Integer deleteTeacher(String teacherNo);

    /**
     * 根据教师标号查询教师详细信息
     * @param teacherNo
     * @return
     */
    Teacher queryTeacher(String teacherNo);
}
