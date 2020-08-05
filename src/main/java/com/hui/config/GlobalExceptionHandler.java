package com.hui.config;

import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import com.hui.common.ReturnJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ReturnJson handlerBusinessException(BusinessException businessException){
        return ReturnJson.error(businessException);
    }

    /**
     * 处理其他异常
     */

    @ExceptionHandler(value = Exception.class)
    public ReturnJson exceptionHandler(Exception e){
        log.info("================【开始打印异常信息】================");
        log.error("具体错误信息:{}", e.getMessage());
        int count = 0; //错误堆栈最多打印50行
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            log.error(stackTraceElement.toString());
            if(count++ > 50) break;
        }
        log.info("================【异常信息打印完毕】================");
        return ReturnJson.error(CommonErrorCode.SERVER_ERROR_500);
    }
}
