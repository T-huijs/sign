package com.hui.model.entity;

import com.hui.model.Entity;
import lombok.Data;


@Data
public class ClassAndGrade extends Entity {

    private String classNo;

    private String className;

    private String classDesc;

    private String profession;

    private String department;

    private String college;


}
