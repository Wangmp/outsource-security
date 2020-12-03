package com.wmp.cn.config.inital;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSONObject;
import com.wmp.cn.dao.RoleDao;
import com.wmp.cn.model.domain.TbRole;
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
@Order(1)
@Slf4j
public class TbRoleRunner implements CommandLineRunner {
    @Autowired
    RoleDao roleDao;

    @Override
    public void run(String... args) throws Exception {
        Long dictCount = roleDao.count();
        if (dictCount == 0) {
            log.info("初始化tb_role表数据开始");
            try {
                //返回读取指定资源的输入流
                InputStream is=this.getClass().getResourceAsStream("/static/TbRole.json");
                String read = IoUtil.read(is, "utf-8");
                List<TbRole> jsonList = JSONObject.parseArray(read, TbRole.class);
                roleDao.saveAll(jsonList);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("初始化tb_role表数据失败，原因：{}",e.getMessage());
            }
            log.info("初始化tb_role表数据结束");
        }
    }
}
