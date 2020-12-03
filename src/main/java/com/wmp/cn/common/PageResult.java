package com.wmp.cn.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页数据对象
 *
 * @author lzkj
 */
@ApiModel(description = "返回分页信息")
@Data
public class PageResult<T> extends Result<T> {
    private static final long serialVersionUID = 1L;

    /**
     * 分页信息
     */
    protected Page page;

    public PageResult(){
        super();
    }


    public PageResult(int code, String msg, T data, Page page) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.page = page;
    }
    @Data
    @ApiModel(description = "分页信息")
    public class Page {
        @ApiModelProperty(value = "第几页")
        long pageNum;

        @ApiModelProperty(value = "页大小")
        long pageSize;

        @ApiModelProperty(value = "总页数")
        long pages;

        @ApiModelProperty(value = "总条数")
        long total;

        public Page(long pageNum, long pageSize, long pages, long total) {
            this.pageNum = pageNum;
            this.pageSize = pageSize;
            this.pages = pages;
            this.total = total;
        }

    }
}