package com.hui.model;

import lombok.Data;

import java.util.Date;

@Data
public class Entity {

    protected Date createTime;

    protected String createBy;

    protected Date updateTime;

    protected String updateBy;

    protected Entity(){
        Date date = new Date();
        this.createTime = date;
        this.createBy = "system";
        this.updateTime = date;
        this.updateBy = "system";
    }

}
