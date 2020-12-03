package com.wmp.cn.model.response;

import lombok.ToString;

/**
 * @Created by wbn
 * @Date 2019/11/28 11:30
 */

@ToString
public enum CommonCode implements ResultCode {

    INVALID_PARAM(false, 10003, "非法参数！"),
    SUCCESS(true, 200, "操作成功！"),
    FAIL(false, 11111, "操作失败！"),
    NOFILE(false, 505, "文件不存在！"),
    DATE_NULL(false, 10000, "未找到相关数据！"),
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 10002, "权限不足，无权操作！"),
    ERRORPLAY(false, 10003, "播送视频失败"),
    USERNAMEISNULL(false, 10004, "用户名不能为空！"),
    PASSWORDISNULL(false, 10005, "密码不能为空！"),
    DATEERROR(false, 10006, "日期解析失败！"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！"),
    NOT_SUPORT_TYPE(false, 10008, "上传文件格式不正确！"),
    NOT_EMPTY_FILE(false,10007,"上传文件不能为空！");
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
