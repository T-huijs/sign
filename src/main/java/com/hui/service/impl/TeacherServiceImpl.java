package com.hui.service.impl;

import com.hui.mapper.TeacherMapper;
import com.hui.model.entity.Teacher;
import com.hui.model.form.UpdateTeacherForm;
import com.hui.model.json.QueryTeacherJson;
import com.hui.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Boolean addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher) > 0;
    }

    @Override
    public Boolean updateTeacher(UpdateTeacherForm updateTeacherForm) {
        return teacherMapper.updateTeacher(updateTeacherForm) > 0;
    }

    @Override
    public Boolean deleteTeacher(String teacherNo) {
        return teacherMapper.deleteTeacher(teacherNo) >0;
    }

    @Override
    public QueryTeacherJson queryTeacher(String teacherNo) {
        Teacher teacher = teacherMapper.queryTeacher(teacherNo);
        if(null == teacher){
            return null;
        }
        QueryTeacherJson queryTeacherJson = new QueryTeacherJson();
        BeanUtils.copyProperties(teacher, queryTeacherJson);
        return queryTeacherJson;
    }
}
