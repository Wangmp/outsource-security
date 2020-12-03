package com.wmp.cn.config.inital;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSONObject;
import com.wmp.cn.dao.SetWinDao;
import com.wmp.cn.model.domain.TbSetWinning;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * @description: 初始化数据
 * @Author: wmp
 * @Date: 2020/7/9 13:53
 */
@Component
@Order(2)
@Slf4j
public class TbSetWinningRunner implements CommandLineRunner {
    @Autowired
    SetWinDao setWinDao;

    @Override
    public void run(String... args) throws Exception {
        Long dictCount = setWinDao.count();
        if (dictCount == 0) {
            log.info("初始化tb_set_winning表数据开始");
            try {
                //返回读取指定资源的输入流
                InputStream is=this.getClass().getResourceAsStream("/static/TbSetWinning.json");
                String read = IoUtil.read(is, "utf-8");
                List<TbSetWinning> jsonList = JSONObject.parseArray(read, TbSetWinning.class);
                setWinDao.saveAll(jsonList);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("初始化tb_set_winning表数据失败，原因：{}",e.getMessage());
            }
            log.info("初始化tb_set_winning表数据结束");
        }
    }
}
