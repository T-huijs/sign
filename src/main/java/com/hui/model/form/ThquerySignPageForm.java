package com.hui.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hui.model.PageForm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ThquerySignPageForm extends PageForm {

    @ApiModelProperty(notes = "课程编号")
    @NotBlank(message = "课程编号不能为空或''")
    private String courseNo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    private String studentNo;


}
