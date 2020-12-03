package com.wmp.cn.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Created by wbn
 * @Date 2019/11/28 11:30
 */
@ToString
@Data
@NoArgsConstructor
public class QueryResponseResult<T> extends ResponseResult {
    private T data;

    public QueryResponseResult(ResultCode resultCode, T data) {
        super(resultCode);
        this.data = data;
    }
}
