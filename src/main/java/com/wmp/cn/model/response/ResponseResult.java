package com.wmp.cn.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Created by wbn
 * @Date 2019/11/28 11:30
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult implements Response {

    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //提示信息
    String message;

    public ResponseResult(String message) {
        this.message=message;
    }


    public ResponseResult(ResultCode resultCode) {
        if (null != resultCode) {
            this.success = resultCode.success();
            this.code = resultCode.code();
            this.message = resultCode.message();
        }
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public static ResponseResult FAIL() {
        return new ResponseResult(CommonCode.FAIL);
    }

}
