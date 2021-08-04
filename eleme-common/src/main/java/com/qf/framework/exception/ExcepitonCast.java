package com.qf.framework.exception;

import com.qf.framework.model.response.ResultCode;

/**
 * Created by 54110 on 2018-10-24.
 */
public class ExcepitonCast {
    public static void cast(ResultCode resultCode){
            throw new CustomException(resultCode);
    }
}
