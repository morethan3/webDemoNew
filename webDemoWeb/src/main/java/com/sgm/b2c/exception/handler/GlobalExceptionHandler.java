package com.sgm.b2c.exception.handler;

import com.sgm.b2c.bo.BaseResponseBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/16.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponseBO<?> defaultExceptionHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        BaseResponseBO baseResponseBO = new BaseResponseBO();
        baseResponseBO.setCode(9999);
        baseResponseBO.setMessage(e.getMessage());
        baseResponseBO.setData(e);
        return baseResponseBO;
    }
}
