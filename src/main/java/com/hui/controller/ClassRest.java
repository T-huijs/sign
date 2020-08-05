package com.hui.controller;

import com.hui.common.ReturnJson;
import com.hui.model.entity.ClassAndGrade;
import com.hui.model.form.classAndGrade.AddClassForm;
import com.hui.model.form.classAndGrade.DeleteClassForm;
import com.hui.model.form.classAndGrade.QueryClassForm;
import com.hui.model.form.classAndGrade.UpdateClassForm;
import com.hui.model.json.QueryClassJson;
import com.hui.service.ClassService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/class")
@RestController
public class ClassRest {

    @Resource
    private ClassService classService;

    @PostMapping("/add")
    @ApiOperation(value="添加班级信息", notes="添加班级信息", response = Boolean.class)
    public ReturnJson addClass(AddClassForm addClassForm){
        ClassAndGrade classAndGrade = new ClassAndGrade();
        BeanUtils.copyProperties(addClassForm, classAndGrade);
        return ReturnJson.success(classService.addClass(classAndGrade));
    }

    @PostMapping("/delete")
    @ApiOperation(value="删除班级信息", notes="删除班级信息", response = Boolean.class)
    public ReturnJson deleteClass(DeleteClassForm deleteClassForm){
        return ReturnJson.success(classService.deleteClass(deleteClassForm.getClassNo()));
    }

    @PostMapping("/update")
    @ApiOperation(value="修改班级信息", notes="修改班级信息", response = Boolean.class)
    public ReturnJson updateClass(UpdateClassForm updateClassForm){
        ClassAndGrade classAndGrade = new ClassAndGrade();
        BeanUtils.copyProperties(updateClassForm, classAndGrade);
        return ReturnJson.success(classService.updateClass(classAndGrade));
    }

    @ApiOperation(value="查询班级信息", notes="查询班级信息", response = QueryClassJson.class)
    @PostMapping("/query")
    public ReturnJson queryClass(QueryClassForm queryClassForm){
        ClassAndGrade classAndGrade = new ClassAndGrade();
        BeanUtils.copyProperties(queryClassForm, classAndGrade);
        return ReturnJson.success(classService.queryClass(classAndGrade));
    }



}
