package com.wmp.cn.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName 用户注册接收参数
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 10:23
 * @Version V1.0
 **/
@Data
@ApiModel("用户注册")
public class TbUserRequest {

//    @ApiModelProperty("角色ID")
//    private Long roleId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("手机号")
    private String mobile;

}
