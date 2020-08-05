package com.hui.controller;

import com.hui.common.Constant;
import com.hui.common.ReturnJson;
import com.hui.model.entity.Course;
import com.hui.model.form.BindCourseForm;
import com.hui.model.form.course.AddCourseForm;
import com.hui.model.form.course.DeleteCourseForm;
import com.hui.model.form.course.QueryCourseForm;
import com.hui.model.form.course.UpdateCourseForm;
import com.hui.model.json.QueryCourseJson;
import com.hui.model.json.QueryOwnCourseJson;
import com.hui.service.CourseService;
import com.hui.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Api(value = "课程相关功能")
@RequestMapping("/course")
@RestController
public class CourseRest {

    @Resource
    private UserService userService;

    @Resource
    private CourseService courseService;

    @ApiOperation(value="添加课程", notes="添加课程", response = Boolean.class)
    @PostMapping("/add")
    public ReturnJson addCourse(AddCourseForm addCourseForm){
        Course course = new Course();
        BeanUtils.copyProperties(addCourseForm, course);
        return ReturnJson.success(courseService.addCourse(course));
    }

    @ApiOperation(value="删除课程信息", notes="删除课程信息", response = Boolean.class)
    @PostMapping("/delete")
    public ReturnJson deleteCourse(DeleteCourseForm deleteCourseForm){
        return ReturnJson.success(courseService.deleteCourse(deleteCourseForm.getCourseNo()));
    }

    @ApiOperation(value="修改课程信息", notes="修改课程信息", response = Boolean.class)
    @PostMapping("/update")
    public ReturnJson updateCourse(UpdateCourseForm updateCourseForm){
        Course course = new Course();
        BeanUtils.copyProperties(updateCourseForm, course);
        return ReturnJson.success(courseService.updateCourse(course));
    }

    @ApiOperation(value="查询课程信息", notes="查询课程信息", response = QueryCourseJson.class)
    @PostMapping("/query")
    public ReturnJson queryCourse(QueryCourseForm queryCourseForm){
        Course course = courseService.queryCourse(queryCourseForm.getCourseNo());
        QueryCourseJson queryCourseJson = new QueryCourseJson();
        BeanUtils.copyProperties(course, queryCourseJson);
        return ReturnJson.success(queryCourseJson);
    }

    @ApiOperation(value="学生选修课程", notes="学生选修课程", response = Boolean.class)
    @PostMapping("/bind_student")
    public ReturnJson bindCourse(BindCourseForm bindCourseForm, HttpServletRequest request){
        String studentNo = userService.getUserNo(request);
        bindCourseForm.setStudentNo(studentNo);
        return ReturnJson.success(courseService.bindStudent(bindCourseForm));
    }

    @ApiOperation(value="老师/学生查看自己名下课程", notes="老师查看自己名下课程", response = QueryOwnCourseJson.class)
    @PostMapping("/query_own")
    public ReturnJson queryOwnCourse(HttpServletRequest request){
        String roleNo = userService.getRoleId(request);
        String userNo = userService.getUserNo(request);
        List<Course> courseList = null;
        if(Constant.ROLE_TEACHER_ID.equals(roleNo)){
            courseList = courseService.queryCourseByTeacherNo(userNo);
        }
        if(Constant.ROLE_STUDENT_ID.equals(roleNo)){
            courseList = courseService.queryCourseByStudentNo(userNo);
        }
        QueryOwnCourseJson queryOwnCourseJson = new QueryOwnCourseJson();
        queryOwnCourseJson.setCourseList(courseList);
        return ReturnJson.success(queryOwnCourseJson);
    }

}
