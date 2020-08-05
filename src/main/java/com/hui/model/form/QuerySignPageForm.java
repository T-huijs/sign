package com.hui.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hui.model.PageForm;
import lombok.Data;

import java.util.Date;


@Data
public class QuerySignPageForm extends PageForm {


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private String studentNo;

    private String courseNo;
}
