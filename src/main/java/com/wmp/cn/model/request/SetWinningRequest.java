package com.wmp.cn.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName 设置中奖率前端参数
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 10:03
 * @Version V1.0
 **/
@Data
@ApiModel(description = "中奖基数")
public class SetWinningRequest {

    @ApiModelProperty("中奖基数")
    private Integer winRate;

}
