package com.wmp.cn.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Created by wbn
 * @Date 2019/11/28 11:30
 */
@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;

    public QueryResult() {
    }

    public QueryResult(List<T> list) {
        this.list = list;
    }

    public QueryResult(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }


    public QueryResult(List<T> list, long total,long sumCount) {
        this.list = list;
        this.total = total;
    }
}
