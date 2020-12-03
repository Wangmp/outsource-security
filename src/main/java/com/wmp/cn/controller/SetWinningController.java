package com.wmp.cn.controller;

import com.wmp.cn.common.BaseController;
import com.wmp.cn.common.Result;
import com.wmp.cn.model.request.SetWinningRequest;
import com.wmp.cn.service.SetWinningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName 设置中奖率
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 9:53
 * @Version V1.0
 **/
@Api(tags = "设置中奖基数")
@RestController
@RequestMapping("/win")
public class SetWinningController extends BaseController {

    @Autowired
    private SetWinningService setWinningService;

    /**
     * 设置中奖率
     */
    @ApiOperation("设置中奖基数")
    @PostMapping("/add")
    public Result addUser(SetWinningRequest setWinningRequest) {
        boolean issuccess = setWinningService.add(setWinningRequest);
        return baseResult(issuccess);
    }

}
