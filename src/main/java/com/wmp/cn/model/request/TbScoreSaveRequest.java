package com.wmp.cn.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TbScoreSaveRequest
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 11:55
 * @Version V1.0
 **/
@Data
@ApiModel("记录分数参数")
public class TbScoreSaveRequest {

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("得分")
    private Integer socre;

}
