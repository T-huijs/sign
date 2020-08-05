package com.hui.service;

import com.hui.model.entity.Teacher;
import com.hui.model.form.UpdateTeacherForm;
import com.hui.model.json.QueryTeacherJson;

public interface TeacherService {

    /**
     * 保存教师信息
     * @return
     */
    Boolean addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @return
     */
    Boolean updateTeacher(UpdateTeacherForm updateTeacherForm);

    /**
     * 删除教师信息
     * @return
     */
    Boolean deleteTeacher(String teacherNo);

    /**
     * 查询教师信息
     * @return
     */
    QueryTeacherJson queryTeacher(String teacherNo);


}
