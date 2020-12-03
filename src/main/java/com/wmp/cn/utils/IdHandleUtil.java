package com.wmp.cn.utils;

import com.wmp.cn.config.exception.BaseException;
import com.wmp.cn.constant.CommonResponse;

/**
 * @author wmp
 * @className IdHandleUtil
 * @description id处理类
 * @Date 2020/8/31 17:12
 */
public class IdHandleUtil {

    /**
     * @Description: 检查ID为空，直接抛异常结束流程
     * @Param: [id] id唯一性标识
     * @return: void 无返回值
     * @Author: zdc
     * @Date: 2020/8/31 17:15
     * @Version: 1.0.0
     * @Company: lzkj
     **/
    public static void checkEmpty(Long id) {
        // id为空，抛异常结束流程
        if (id == null) {
            throw new BaseException(CommonResponse.EMPTY_ID);
        }
    }

}
