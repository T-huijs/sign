package com.hui.common;

public class CommonErrorCode {

    /**
     * 请求成功-0000
     * 请求失败-9999
     * 公共相关-000001-000999
     * 业务相关-001000-009999
     *
     */

    public static final Response SUCCESS = new Response("0000", "请求成功");

    public static final Response ERROR = new Response("9999", "请求失败");

    public static final Response PARAM_ERROR = new Response("000001", "参数异常");


    public static final Response SERVER_ERROR_500 = new Response("500", "服务器内部错误");

    public static final Response ACCOUNT_OR_PWD_ERROR = new Response("001000", "所选角色下账号密码错误");

    public static final Response NO_LOGIN = new Response("001001", "用户未登陆");

    public static final Response ACCOUNT_EXISTS = new Response("001002", "该账号已经存在");

    public static final Response LOGIN_FAILURE = new Response("001003", "登录失效，请重新登录");

    public static final Response ROLE_NOT_PROFESSION = new Response("001004", "当前用户没有该接口访问权限");

    public static final Response DATE_ALL_NULL_NOTNULL = new Response("001100", "开始日期和终止日期必须同时为空或者都不为空");

    public static final Response STUDENT_NO_NULL = new Response("001101", "学号不能为空");

    public static final Response STUDENT_NOT_TEACHER = new Response("001102", "该学生未选修你的课程，请确认所输入学号是否正确");



}
