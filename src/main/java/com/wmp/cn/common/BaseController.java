package com.wmp.cn.common;

import com.wmp.cn.constant.ExceptionCodes;
import com.wmp.cn.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * web层通用数据处理
 *
 * @author lzkj
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected String defaultFailMsg = "操作失败";

    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }

    /**
     * 无数据返回
     *
     * @return 操作结果
     */
    protected Result baseResult() {
        return new Result(ExceptionCodes.SUCCESS.getCode(), ExceptionCodes.SUCCESS.getMessage());
    }

    /**
     * 返回写操作的结果
     *
     * @return 操作结果
     */
    protected <T> Result<T> baseResult(int rows) {
        return rows > 0 ? new Result(ExceptionCodes.SUCCESS.getCode(), ExceptionCodes.SUCCESS.getMessage()) : new Result(ExceptionCodes.ERROR.getCode(), defaultFailMsg);
    }

    /**
     * 返回消息成功
     *
     * @return 操作结果
     */
    protected <T> Result<T> baseResult(String msg) {
        return new Result(ExceptionCodes.SUCCESS.getCode(), msg);
    }

    /**
     * 返回有数据
     *
     * @return 操作结果
     */
    protected <T> Result<T> baseResult(T data) {
        return new Result(ExceptionCodes.SUCCESS.getCode(), ExceptionCodes.SUCCESS.getMessage(), data);
    }

    /**
     *
     * @param success
     * @param msg
     * @return
     */
    protected Result baseResult(Boolean success, String msg) {
        return success ? baseResult() : new Result(ExceptionCodes.ERROR.getCode(), StringUtils.isEmpty(msg) ? defaultFailMsg : msg);
    }

    /**
     *
     * @param success
     * @return
     */
    protected Result baseResult(Boolean success) {
        return success ? baseResult() : new Result(ExceptionCodes.ERROR.getCode(), defaultFailMsg);
    }

}
