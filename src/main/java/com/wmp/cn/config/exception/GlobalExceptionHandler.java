package com.wmp.cn.config.exception;

import com.wmp.cn.constant.ExceptionCodes;
import com.wmp.cn.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.login.AccountExpiredException;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理器
 *
 * @author lzkj
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 基础异常
     */
    @ExceptionHandler(Exception.class)
    public MapResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return MapResult.error(ExceptionCodes.ERROR.getMessage(), e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BaseException.class)
    public MapResult businessException(BaseException e) {
        log.error(e.getMessage(), e);
        if (StringUtils.isNull(e.getCode())) {
            return MapResult.error(e.getMessage());
        }
        return MapResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 路径不对或者服务没有
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public MapResult handlerNoFoundException(Exception e) {
        log.error(ExceptionCodes.SERVICE_NOT_FOUND.getMessage(), e);
        return MapResult.error(ExceptionCodes.SERVICE_NOT_FOUND);
    }

    /**
     *  拦截权限不足异常
     *  权限注解@PreAuthorize会抛出AccessDeniedException异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public MapResult handleAuthorizationException(AccessDeniedException e) {
        log.error(ExceptionCodes.FORBIDDEN.getMessage(), e);
        return MapResult.error(ExceptionCodes.FORBIDDEN);
    }

    @ExceptionHandler(AccountExpiredException.class)
    public MapResult handleAccountExpiredException(AccountExpiredException e) {
        log.error(e.getMessage(), e);
        return MapResult.error(e.getMessage());
    }
    
    /**
     * 自定义绑定验证异常
     */
    @ExceptionHandler(BindException.class)
    public MapResult validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        return MapResult.error(ExceptionCodes.CHECK_ERROR.getCode(), e.getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        return MapResult.error(ExceptionCodes.PARAM_ERROR.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 其他参数异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handleParameterException(MissingServletRequestParameterException e) {
        log.error(ExceptionCodes.PARAM_ERROR.getMessage(), e);
        return MapResult.error(ExceptionCodes.PARAM_ERROR.getCode(), ExceptionCodes.PARAM_ERROR.getMessage()+ e.getMessage());
    }

}
