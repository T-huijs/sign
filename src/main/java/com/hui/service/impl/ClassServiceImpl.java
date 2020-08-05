package com.hui.service.impl;

import com.hui.mapper.ClassMapper;
import com.hui.model.entity.ClassAndGrade;
import com.hui.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;
    @Override
    public Boolean addClass(ClassAndGrade classAndGrade) {
        return classMapper.addClass(classAndGrade) > 0;
    }

    @Override
    public Boolean updateClass(ClassAndGrade classAndGrade) {
        return classMapper.updateClass(classAndGrade) > 0;
    }

    @Override
    public Boolean deleteClass(String classNo) {
        return classMapper.deleteClass(classNo) > 0;
    }

    @Override
    public ClassAndGrade queryClass(ClassAndGrade classAndGrade) {
        return classMapper.queryClass(classAndGrade);
    }

    @Override
    public ClassAndGrade queryClassByClassNo(String classNo){
        ClassAndGrade classAndGrade = new ClassAndGrade();
        classAndGrade.setClassNo(classNo);
        return this.queryClass(classAndGrade);
    }
}
