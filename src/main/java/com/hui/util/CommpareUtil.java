package com.hui.util;

import com.hui.common.BusinessException;
import com.hui.common.CommonErrorCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommpareUtil {


    /**
     * 同为空或者都不为空
     * @param obj1
     * @param obj2
     * @return
     */
    public static Boolean allNullOrNotNull(Object obj1, Object obj2){
        if((null == obj1 && null == obj2) || (null != obj1 && null != obj2)){
            return true;
        }
        return false;
    }


    public static Boolean equals(String str1, String str2){
        if(null == str1){
            log.error("CommpareUtil.equals str1={} ", str1);
            throw new BusinessException(CommonErrorCode.PARAM_ERROR.getResCode(),"str1不能为空");
        }
        return str1.equalsIgnoreCase(str2);
    }

}
