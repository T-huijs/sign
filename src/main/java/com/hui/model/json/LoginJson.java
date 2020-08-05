package com.hui.model.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class LoginJson {

    private String userNo;

    private String roleId;
}
