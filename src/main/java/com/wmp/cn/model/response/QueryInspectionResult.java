package com.wmp.cn.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName QueryInspectionResult
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/6/23
 * @Version V1.0
 * 返回巡检数据
 **/
@Data
@ToString
public class QueryInspectionResult<T> {
    //数据列表
    private List<T> list;

    private long total;

    public QueryInspectionResult() {
    }

    public QueryInspectionResult(List<T> list) {
        this.list = list;
    }

}
