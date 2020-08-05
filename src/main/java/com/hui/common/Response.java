package com.hui.common;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Response {

    private String resCode;

    private String resMsg;

    public Response(String resCode, String resMsg){
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public Response(BusinessException businessException){
        this(businessException.getErrorCode(), businessException.getErrorMsg());
    }

}
