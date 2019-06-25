package com.mmt.common.exception;

import com.mmt.common.model.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@ControllerAdvice
@ResponseBody
public class ServiceExceptionController {
    public static final String ARGS_NOT_VALID = "输入参数不合法";
    public static final String UNKNOWN_ERROR = "未知错误";
    private static Pattern p = Pattern.compile("Duplicate entry '(.*?)'.*");

    private static final Logger log = LoggerFactory.getLogger(ServiceExceptionController.class);
    private String msg = "handler unknown exception";

    public ServiceExceptionController() {
    }

    @ExceptionHandler({Exception.class})
    public RestResponse handlerUnKnownException(Exception e) {
        log.error(this.msg, e);
        return RestResponse.buildFailed(UNKNOWN_ERROR);
    }

    @ExceptionHandler({IllegalArgumentException.class, HttpRequestMethodNotSupportedException.class})
    public RestResponse handlerIllegalArgumentException(Exception e) {
        log.error(this.msg, e);
        return RestResponse.builedFaild(400,ARGS_NOT_VALID);
    }

    @ExceptionHandler({ServiceException.class})
    public RestResponse handlerServiceException(ServiceException e) {
        log.info("service exception {}", e);
        return RestResponse.buildFailed(null);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public RestResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("方法参数异常：异常信息：{}", e);
        return RestResponse.buildFailed("参数 " + e.getBindingResult().getFieldError().getField() + " " +
                e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler({BindException.class})
    public RestResponse handlerBindException(BindException e) {
        log.warn("参数绑定异常：异常信息：{}", e);
        return RestResponse.buildFailed("字段" + e.getBindingResult().getFieldError().getField() + " " +
                e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class, DuplicateKeyException.class})
    public RestResponse handlerSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        Matcher m = p.matcher(e.getMessage());
        log.warn("参数异常：{}", e);
        if (m.find())
            return RestResponse.buildFailed("输入的数据已存在，请检查输入值：" + m.group(1));
        else
            return RestResponse.buildFailed(ARGS_NOT_VALID);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public RestResponse handlerHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn("参数不合法：{}", e);
        return RestResponse.buildFailed(ARGS_NOT_VALID);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public RestResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return RestResponse.buildFailed("缺少" + e.getParameterName());
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    public RestResponse handlerConstraintViolationException(Exception e) {
        log.warn("参数校验异常：{}", e);
        return RestResponse.buildFailed(ARGS_NOT_VALID);
    }

}
