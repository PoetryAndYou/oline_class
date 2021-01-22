package com.yantumeijing.oline_class.exception;

import com.yantumeijing.oline_class.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 */
@ControllerAdvice
public class CustomExceptionHander {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHander.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {
        logger.error("[ 系统异常 ]{}", e);
        if (e instanceof YTException) {
            YTException ytException = (YTException) e;
            return JsonData.buildError(ytException.getCode(), ytException.getMsg());
        } else {
            return JsonData.buildError("全局异常，未知错误！");
        }

    }
}
