package com.wmp.cn.common;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应消息
 *
 * @author lzkj
 */
@ApiModel(description = "返回信息")
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "响应码")
    protected int code;

    @ApiModelProperty(value = "响应消息")
    protected String msg;

    @ApiModelProperty(value = "响应数据")
    protected T data;

    public Result() {
        super();
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
