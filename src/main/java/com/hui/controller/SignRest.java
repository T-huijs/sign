package com.hui.controller;

import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import com.hui.common.ReturnJson;
import com.hui.model.entity.Sign;
import com.hui.model.form.AddSignForm;
import com.hui.model.form.QuerySignPageForm;
import com.hui.model.form.ThquerySignPageForm;
import com.hui.model.form.ThupdateSignForm;
import com.hui.model.json.QueryCourseJson;
import com.hui.model.json.QuerySignPageJson;
import com.hui.model.json.ThquerySignPageJson;
import com.hui.service.SignService;
import com.hui.service.UserService;
import com.hui.util.CommpareUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(value = "签到相关功能")
@RequestMapping("/sign")
@RestController
public class SignRest {

    @Resource
    private UserService userService;

    @Resource
    private SignService signService;


    @PostMapping("/sign_student")
    @ApiOperation(value="学生签到", notes="学生签到", response = QueryCourseJson.class)
    public ReturnJson signWithStudent(AddSignForm signForm, HttpServletRequest request){
        String studentNo = userService.getUserNo(request);
        Sign sign = new Sign();
        BeanUtils.copyProperties(signForm, sign);
        sign.setStudentNo(studentNo);
        return ReturnJson.success(signService.signWithStudent(sign));
    }

    @PostMapping("/query_sign_student")
    @ApiOperation(value="学生-查看自己签到情况", notes="学生-查看自己签到情况", response = QuerySignPageJson.class)
    public ReturnJson querySignWithStudent(QuerySignPageForm signPageForm, HttpServletRequest request){
        String studentNo = userService.getUserNo(request);
        signPageForm.setStudentNo(studentNo);
        if(!CommpareUtil.allNullOrNotNull(signPageForm.getStartTime(), signPageForm.getEndTime())){
            throw new BusinessException(CommonErrorCode.DATE_ALL_NULL_NOTNULL);
        }
        return ReturnJson.success(signService.querySignByStudentNo(signPageForm));
    }

    @PostMapping("/query_sign_teacher")
    @ApiOperation(value="老师-查看学生签到情况", notes="老师-查看学生签到情况", response = ThquerySignPageJson.class)
    public ReturnJson querySignForTeacher(ThquerySignPageForm thquerySignForm, HttpServletRequest request){
        String teacherNo = userService.getUserNo(request);
        //此处需要校验是否有课程权限。
        return ReturnJson.success(signService.querySignForTeacher(thquerySignForm));
    }

    @PostMapping("/update_sign_teacher")
    @ApiOperation(value="老师-修改学生签到情况", notes="老师-修改学生签到情况", response = QueryCourseJson.class)
    public ReturnJson updateSignForTeacher(ThupdateSignForm thupdateSignForm, HttpServletRequest request){
        //此处需要校验是否有课程权限。

        return ReturnJson.success(null);
    }


}
