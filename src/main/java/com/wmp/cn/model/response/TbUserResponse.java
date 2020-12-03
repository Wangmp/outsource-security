package com.wmp.cn.model.response;

import com.wmp.cn.model.domain.TbUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TbUserResponse
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 10:38
 * @Version V1.0
 **/
@Data
public class TbUserResponse {

    @ApiModelProperty("今日踢球次数")
    private Integer isTodayPyayCount;

    //用户信息
    @ApiModelProperty("用户信息")
    private TbUser tbUser;

}
