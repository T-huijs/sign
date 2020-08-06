package com.hui.mapper;

import com.hui.model.entity.ClassAndGrade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {

    /**
     * 添加班级
     * @param ClassAndGrade
     * @return
     */
    Integer addClass(ClassAndGrade ClassAndGrade);

    /**
     * 修改班级信息
     * @param ClassAndGrade
     * @return
     */
    Integer updateClass(ClassAndGrade ClassAndGrade);

    /**
     * 删除班级信息
     * @param classNo
     * @return
     */
    Integer deleteClass(String classNo);

    /**
     * 查询班级信息
     * @param classAndGrade
     * @return
     */
    ClassAndGrade queryClass(ClassAndGrade classAndGrade);

}
