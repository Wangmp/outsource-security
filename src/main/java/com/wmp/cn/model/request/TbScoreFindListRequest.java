package com.wmp.cn.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TbUserFindListRequest
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 10:59
 * @Version V1.0
 **/
@Data
@ApiModel(description = "查询列表参数")
public class TbScoreFindListRequest {

    @ApiModelProperty("分页页数")
    private int page = 0;

    @ApiModelProperty("每页条数")
    private int size = 10;

    @ApiModelProperty("用户名（模糊）")
    private String userName;

    @ApiModelProperty("手机号（模糊）")
    private String mobile;

    @ApiModelProperty("是否中奖 0、未中奖  1、已中奖")
    private String isWin;

}
