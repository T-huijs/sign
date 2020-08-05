package com.hui.mapper;

import com.hui.model.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    Integer addStudent(Student student);

    Student queryStudent(String studentNo);

    Integer updateStudent(Student student);

    Integer deleteStudent(String studentNo);

    Integer queryStudentCountByTeacherNo(@Param("studentNo") String studentNo, @Param("teacherNo") String teacherNo);
}
