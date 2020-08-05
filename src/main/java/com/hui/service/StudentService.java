package com.hui.service;

import com.hui.model.entity.Student;
import com.hui.model.json.QueryStudentJson;

public interface StudentService {

    Boolean addStudent(Student student);

    QueryStudentJson queryStudent(String studentNo);

    Boolean updateStudent(Student student);

    Boolean deleteStudent(String studentNo);

    /**
     * 学生是否选修该教师名下的课程
     * @param studentNo
     * @param teacherNo
     * @return
     */
    Boolean isCheckStudentByTeacherNo(String studentNo, String teacherNo);
}
