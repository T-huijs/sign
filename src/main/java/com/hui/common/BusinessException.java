package com.hui.common;

import lombok.Data;


@Data
public class BusinessException extends RuntimeException {

    private String errorCode;

    private String errorMsg;

    public BusinessException(Response response){
        this(response.getResCode(), response.getResMsg());
    }

    public BusinessException(String errorCode, String errorMsg){
        super();   //此处可以不写-因为子类构造方法默认拥有父类无参构造方法
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(String message){
        this(CommonErrorCode.ERROR.getResCode(), message);
    }

}
