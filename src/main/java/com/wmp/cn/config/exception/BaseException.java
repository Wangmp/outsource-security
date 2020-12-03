package com.wmp.cn.config.exception;


import com.wmp.cn.constant.ExceptionCodes;

/**
 * 自定义业务异常
 *
 * @author lzkj
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String message;

    public BaseException(String message) {
        this.message = message;
    }

//    public BaseException(String message, Integer code) {
//        this.message = message;
//        this.code = code;
//    }
    public BaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(ExceptionCodes exceptionCodes) {
        this.code = exceptionCodes.getCode();
        this.message = exceptionCodes.getMessage();
    }

    public BaseException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
