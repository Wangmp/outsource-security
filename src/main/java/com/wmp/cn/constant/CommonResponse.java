package com.wmp.cn.constant;

/**
 * @author zdc
 * @className CommonResponse
 * @description 通用响应常量
 * @Date 2020/8/28 17:05
 */
public final class CommonResponse {

    // 私有化构造器
    private CommonResponse() {
    }

    public static final Integer DEL_FLAG_NOT = 0; //未删除
    public static final Integer DEL_FLAG = 1;  //已删除

    public static final String EMPTY_ID = "ID不能为空！";
    public static final String PARAMETER_ERROR = "参数错误！";
    public static final String NOT_FOUND_ROLE = "未找到相关角色信息！";
    public static final String NOT_FOUND_USER = "未找到相关用户信息！";
    public static final String ALREADY_DONE = "您今天已经踢过，请明天再来！";
    public static final String OPERATE_SUCESS = "操作成功！";
    public static final String OPERATE_FAIL = "操作失败！";
}

