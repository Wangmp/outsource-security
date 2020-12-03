package com.wmp.cn.controller;

import com.wmp.cn.common.BaseController;
import com.wmp.cn.common.Result;
import com.wmp.cn.model.request.TbUserRequest;
import com.wmp.cn.model.response.TbUserResponse;
import com.wmp.cn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/24 16:26
 * @Version V1.0
 **/
@Api(tags = "用户信息相关接口")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;

    /**
     * 新增用户信息
     */
    @ApiOperation("新增用户信息(用户注册)")
    @PostMapping("/add")
    public Result addUser(@RequestBody TbUserRequest tbUserRequest) {
        TbUserResponse tbUserResponse = userService.addTbUser(tbUserRequest);
        return baseResult(tbUserResponse);
    }

//    /**
//     * 获取用户信息
//     */
//    @ApiOperation("获取用户信息")
//    @GetMapping("/get/{id}")
//    public Result<TbUser> getUser(@PathVariable Long id) {
//        IdHandleUtil.checkEmpty(id);
//        return baseResult(userService.getTbUser(id));
//    }

}
