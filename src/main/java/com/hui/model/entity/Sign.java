package com.hui.model.entity;


import com.hui.model.Entity;
import lombok.Data;

import java.util.Date;

/**
 * 签到记录
 */
@Data
public class Sign extends Entity {

    private String studentNo;

    private String courseNo;

    private Date signTime;
}
