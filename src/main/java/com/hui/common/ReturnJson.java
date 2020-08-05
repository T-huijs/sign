package com.hui.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 返回包装类
 * @param <T>
 */
@Data
public class ReturnJson<T> {

    @JSONField(ordinal=1)
    private String code;

    @JSONField(ordinal=2)
    private String msg;

    @JSONField(ordinal=3)
    private T data;

    public ReturnJson(String code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReturnJson(Response response){
        this.code = response.getResCode();
        this.msg = response.getResMsg();
        this.data = null;
    }

    public ReturnJson(Response response, T data){
        this(response.getResCode(), response.getResMsg(), data);

    }

    public static ReturnJson success(Object data){
        return new ReturnJson(CommonErrorCode.SUCCESS, data);
    }

    public static ReturnJson error(Response response){
        return new ReturnJson(response);
    }

    public static ReturnJson error(BusinessException businessException){
        return error(new Response(businessException));
    }



}
