package com.wmp.cn.controller;

import com.wmp.cn.common.BaseController;
import com.wmp.cn.common.Result;
import com.wmp.cn.model.domain.TbScore;
import com.wmp.cn.model.request.TbScoreFindListRequest;
import com.wmp.cn.model.request.TbScoreSaveRequest;
import com.wmp.cn.model.response.QueryResponseResultList;
import com.wmp.cn.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName 记录分数
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 9:55
 * @Version V1.0
 **/
@Api(tags = "记录分数相关接口")
@RestController
@RequestMapping("/score")
public class ScoreController extends BaseController {

    @Autowired
    private ScoreService scoreService;

    /**
     * 记录分数
     */
    @ApiOperation("记录分数")
    @PostMapping("/add")
    public Result add(@RequestBody TbScoreSaveRequest tbScoreSaveRequest) {
        TbScore tbScore = scoreService.add(tbScoreSaveRequest);
        return baseResult(tbScore);
    }

    /**
     * @Description:根据条件筛选数据
     * @Author: wmp
     * @Date:
     **/
    @ApiIgnore
    @PostMapping("/selectData")
    public QueryResponseResultList selectData(TbScoreFindListRequest tbScoreFindListRequest){
        //查询列表
        QueryResponseResultList queryResponseResultList = scoreService.getListTbScore(tbScoreFindListRequest);
        return queryResponseResultList;
    }


}
