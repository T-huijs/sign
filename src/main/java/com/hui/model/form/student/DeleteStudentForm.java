package com.hui.model.form.student;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeleteStudentForm {

    @NotBlank(message = "学号不能为空或''")
    private String studentNo;
}
