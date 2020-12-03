package com.wmp.cn.controller.web;

import com.wmp.cn.model.request.TbScoreFindListRequest;
import com.wmp.cn.service.ScoreService;
import com.wmp.cn.service.SetWinningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @ClassName IndexController
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 15:01
 * @Version V1.0
 **/
@ApiIgnore
@Controller
@RequestMapping("home")
public class IndexController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private SetWinningService setWinningService;

    /**
     * @Description:首页
     * @Author: wmp
     * @Date:
     **/
    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toIndex(TbScoreFindListRequest tbScoreFindListRequest, Model model){
        //中奖基数
        model.addAttribute("winRate",setWinningService.findByDelFlag().getWinRate());
        //查询列表
        model.addAttribute("scoreDate",scoreService.getListTbScore(tbScoreFindListRequest));
        //统计总分
        model.addAttribute("countDate",scoreService.countScore());
        return "home";
    }

}
