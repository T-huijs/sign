package com.hui.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageForm {

    @ApiModelProperty(name = "起始行")
    protected Integer pageIndex;

    @ApiModelProperty(name = "每页条数")
    protected Integer pageSize;

    protected PageForm(){
        this.pageIndex = 0;
        this.pageSize = 10;
    }

    protected void setPageIndex(Integer pageNum, Integer pageSize){
        if(null == pageNum || 1 > pageNum){
            this.pageIndex = 0;
            return;
        }
        this.pageIndex = (pageNum-1)*pageSize;
    }

}
