package com.wmp.cn.controller;

import com.wmp.cn.common.BaseController;
import com.wmp.cn.common.Result;
import com.wmp.cn.model.domain.TbRole;
import com.wmp.cn.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 9:43
 * @Version V1.0
 **/
@Api(tags = "角色相关接口")
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色信息
     */
    @ApiOperation("获取角色信息列表")
    @GetMapping("/list")
    public Result<List<TbRole>> getRoleList() {
        return baseResult(roleService.findList());
    }



}
