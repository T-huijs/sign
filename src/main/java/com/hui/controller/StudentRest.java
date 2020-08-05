package com.hui.controller;

import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import com.hui.common.Constant;
import com.hui.common.ReturnJson;
import com.hui.model.entity.Student;
import com.hui.model.form.UpdateStudentInfoForm;
import com.hui.model.form.student.AddStudentForm;
import com.hui.model.form.student.DeleteStudentForm;
import com.hui.model.form.student.QueryStudentForm;
import com.hui.model.json.QueryCourseJson;
import com.hui.model.json.QueryStudentJson;
import com.hui.service.StudentService;
import com.hui.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RequestMapping("/student")
@RestController
public class StudentRest {

    @Resource
    private UserService userService;

    @Resource
    private StudentService studentService;

    /*@ApiOperation(value="添加学生信息", notes="添加学生信息", response = Boolean.class)
    @PostMapping("/add")
    public ReturnJson addStudent(AddStudentForm addStudentForm, HttpServletRequest request){
        String userNo = userService.getUserNo(request);
        Student student = new Student();
        BeanUtils.copyProperties(addStudentForm, student);
        student.setStudentNo(userNo);
        return ReturnJson.success(studentService.addStudent(student));
    }
*/
    @ApiOperation(value="删除学生信息", notes="删除学生信息", response = QueryCourseJson.class)
    @PostMapping("/delete")
    public ReturnJson deleteStudent(DeleteStudentForm deleteStudentForm){
        return ReturnJson.success(studentService.deleteStudent(deleteStudentForm.getStudentNo()));
    }

    @ApiOperation(value="修改学生信息", notes="修改学生信息", response = QueryCourseJson.class)
    @PostMapping("/update")
    public ReturnJson updateStudent(UpdateStudentInfoForm updateStudentInfoForm, HttpServletRequest request){
        String studentNo = userService.getUserNo(request);
        Student student = new Student();
        BeanUtils.copyProperties(updateStudentInfoForm, student);
        student.setStudentNo(studentNo);
        return ReturnJson.success(studentService.updateStudent(student));
    }

    @ApiOperation(value="查询单个学生信息", notes="查询学生信息-通过学号", response = QueryStudentJson.class)
    @PostMapping("/query")
    public ReturnJson queryStudent(QueryStudentForm queryStudentForm, HttpServletRequest request){
        String userNo = userService.getUserNo(request);
        String roleId = userService.getRoleId(request);
        if(Constant.ROLE_STUDENT_ID.equals(roleId)){
            return ReturnJson.success(studentService.queryStudent(userNo));
        }
        if(null == queryStudentForm || StringUtils.isEmpty(queryStudentForm.getStudentNo())){
            throw new BusinessException(CommonErrorCode.STUDENT_NO_NULL);
        }
        String studentNo = queryStudentForm.getStudentNo();
        //教师角色校验是否有权限查询指定学生信息
        if(Constant.ROLE_TEACHER_ID.equals(roleId)){
            if(!studentService.isCheckStudentByTeacherNo(studentNo, userNo)){
                throw new BusinessException(CommonErrorCode.STUDENT_NOT_TEACHER);
            }
        }
        return ReturnJson.success(studentService.queryStudent(studentNo));
    }

    /**
     * 教师查看学生信息
     * 入参 - 学生编号
     */

}
