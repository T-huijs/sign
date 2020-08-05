package com.hui.controller;

import com.hui.common.ReturnJson;
import com.hui.model.entity.Teacher;
import com.hui.model.form.AddTeacherForm;
import com.hui.model.form.DeleteTeacherForm;
import com.hui.model.form.UpdateTeacherForm;
import com.hui.model.json.QueryCourseJson;
import com.hui.service.TeacherService;
import com.hui.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RequestMapping("/teacher")
@RestController
public class TeacherRest {

    @Resource
    private UserService userService;
    @Resource
    private TeacherService teacherService;

    @ApiOperation(value="录入教师详细信息", notes="录入教师详细信息", response = Boolean.class)
    @PostMapping("/add")
    public ReturnJson addTeacher(AddTeacherForm addTeacherForm, HttpServletRequest request){
        String teacherNo = userService.getUserNo(request);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(addTeacherForm, teacher);
        teacher.setTeacherNo(teacherNo);
        return ReturnJson.success(teacherService.addTeacher(teacher));
    }

    @ApiOperation(value="修改教师信息", notes="修改教师信息", response = Boolean.class)
    @PostMapping("/update")
    public ReturnJson updateTeacher(UpdateTeacherForm updateTeacherForm, HttpServletRequest request){
        //校验权限
        return ReturnJson.success(teacherService.updateTeacher(updateTeacherForm));
    }

    @ApiOperation(value="删除教师信息", notes="删除教师信息", response = Boolean.class)
    @PostMapping("/delete")
    public ReturnJson deleteTeacher(DeleteTeacherForm deleteTeacherForm, HttpServletRequest request){
        //待校验角色
        return ReturnJson.success(teacherService.deleteTeacher(deleteTeacherForm.getTeachNo()));
    }


    @ApiOperation(value="查询教师信息", notes="(教师)查询教师信息", response = QueryCourseJson.class)
    @PostMapping("/query")
    public ReturnJson queryTeacher(HttpServletRequest request){
        String teacherNo = userService.getUserNo(request);
        return ReturnJson.success(teacherService.queryTeacher(teacherNo));
    }

}
