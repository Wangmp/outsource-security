package com.wmp.cn.config.exception;


import com.wmp.cn.constant.ExceptionCodes;

import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author lzkj
 */
public class MapResult<T> extends HashMap<String, Object> {

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";
    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";
    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";
    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 MapResult 对象，使其表示一个空消息。
     */
    public MapResult() {
    }

    /**
     * 初始化一个新创建的 MapResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public MapResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 MapResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public MapResult(int code, String msg, T data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static MapResult success() {
        return MapResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static MapResult success(Object data) {
        return MapResult.success("操作成功" , data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static MapResult success(String msg) {
        return MapResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static MapResult success(String msg, Object data) {
        return new MapResult(ExceptionCodes.SUCCESS.getCode(), msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static MapResult error() {
        return MapResult.error(ExceptionCodes.ERROR.getMessage());
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static MapResult error(String msg) {
        return MapResult.error(ExceptionCodes.ERROR.getCode(), msg);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static MapResult error(String msg, Object data) {
        return new MapResult(ExceptionCodes.ERROR.getCode(), msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static MapResult error(int code, String msg) {
        return new MapResult(code, msg, null);
    }

    /**
     * 返回错误消息
     *
     * @return 警告消息
     */
    public static MapResult error(ExceptionCodes exceptionCodes) {
        return new MapResult(exceptionCodes.getCode(), exceptionCodes.getMessage());
    }

}
