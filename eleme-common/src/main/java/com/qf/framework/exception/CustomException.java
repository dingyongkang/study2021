package com.qf.framework.exception;


import com.qf.framework.model.response.ResultCode;

/**
 * Created by 54110 on 2018-10-24.
 */
public class CustomException extends RuntimeException {
            private ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        super("错误代码："+resultCode+"错误信息："+resultCode.message());
        this.resultCode=resultCode;
    }
    public ResultCode getResultCode(){
        return this.resultCode;
    }
}
