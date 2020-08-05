package com.hui.service.impl;

import com.hui.mapper.StudentMapper;
import com.hui.model.entity.ClassAndGrade;
import com.hui.model.entity.Student;
import com.hui.model.json.QueryStudentJson;
import com.hui.service.ClassService;
import com.hui.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private ClassService classService;

    @Override
    public Boolean addStudent(Student student) {
        return studentMapper.addStudent(student) > 0;
    }

    @Override
    public QueryStudentJson queryStudent(String studentNo) {
        Student student = queryStudentByStudentNo(studentNo);
        if(null == student){
            return null;
        }
        QueryStudentJson queryStudentJson = new QueryStudentJson();
        BeanUtils.copyProperties(student, queryStudentJson);
        ClassAndGrade classAndGrade = classService.queryClassByClassNo(student.getClassNo());
        BeanUtils.copyProperties(classAndGrade, queryStudentJson);
        return queryStudentJson;
    }


    private Student queryStudentByStudentNo(String studentNo) {
        return studentMapper.queryStudent(studentNo);
    }

    @Override
    public Boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student) > 0;
    }

    @Override
    public Boolean deleteStudent(String studentNo) {
        return studentMapper.deleteStudent(studentNo) > 0;
    }

    @Override
    public Boolean isCheckStudentByTeacherNo(String studentNo, String teacherNo){
        return studentMapper.queryStudentCountByTeacherNo(studentNo, teacherNo) > 0;
    }
}
