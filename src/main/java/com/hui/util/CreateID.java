package com.hui.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CreateID {

    /**
     * 生成唯一uuid
     * UUID  唯一识别码，16个字节 （128位）
     * 组成部分：当前日期+时间+时钟的序列+mac地址 + 业务类型
     */
    public static String getUUid(String type){
        if(StringUtils.isEmpty(type)){
            type = "0000";
        }

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyMMdd");
        String time = format.format(date);
        System.out.println("uuid:" + UUID.randomUUID().toString());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        int hashCodeV = uuid.hashCode();
        if (hashCodeV < 0)
        {// 有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 11 代表长度为11
        // d 代表参数为正数型
        return time + String.format("%011d", hashCodeV) + type;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getUUid("user"));
        }
    }
}
