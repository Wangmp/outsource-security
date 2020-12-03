package com.wmp.cn.model.response;

/**
 * @ClassName ReturnResultCode
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/6/30
 * @Version V1.0
 **/
public enum  ReturnResultCode {

    /*成功状态码*/
    SUCCESS(200,"操作成功"),

    INVALID_PARAM(10003,  "非法参数！"),

    FINDINFO_NULL(10004,"未找到相关信息！"),

    /*系统500错误*/
    SYSTEM_ERROR(10000,"系统异常，请稍后再试"),
    UNAUTHORIZED(10401,"签名验证失败"),

    /*参数错误 10001-29999*/
    PARAM_IS_INVALID(10001,"参数无效"),

    /*用户错误：20001-29999*/
    USER_HAS_EXISTED(20001,"用户名已存在"),
    USER_NOT_FIND(20002,"用户名不存在");

    private Integer code;
    private String message;

    ReturnResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer code(){return code;}

    public String message(){return message;}


}
