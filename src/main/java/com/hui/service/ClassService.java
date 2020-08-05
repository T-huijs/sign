package com.hui.service;

import com.hui.model.entity.ClassAndGrade;

public interface ClassService {

    /**
     * 添加班级
     * @param ClassAndGrade
     * @return
     */
    Boolean addClass(ClassAndGrade ClassAndGrade);

    /**
     * 修改班级信息
     * @param ClassAndGrade
     * @return
     */
    Boolean updateClass(ClassAndGrade ClassAndGrade);

    /**
     * 删除班级信息
     * @param classNo
     * @return
     */
    Boolean deleteClass(String classNo);

    /**
     * 查询班级信息
     * @param classAndGrade
     * @return
     */
    ClassAndGrade queryClass(ClassAndGrade classAndGrade);

    /**
     * 根据班级编号查询班级信息
     * @param classNo
     * @return
     */
    ClassAndGrade queryClassByClassNo(String classNo);
}
