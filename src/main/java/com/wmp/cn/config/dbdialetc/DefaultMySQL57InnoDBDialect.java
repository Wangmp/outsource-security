package com.wmp.cn.config.dbdialetc;

import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.stereotype.Component;

/**
 * @ClassName DefaultMySQL57InnoDBDialect
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/7/10
 * @Version V1.0
 **/
@Component
@SuppressWarnings("deprecation")
public class DefaultMySQL57InnoDBDialect extends MySQL57Dialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }

}
