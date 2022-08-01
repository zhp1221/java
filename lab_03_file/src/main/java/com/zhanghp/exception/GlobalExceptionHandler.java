package com.zhanghp.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author zhanghp
 * @date 2022-07-21 14:12
 */
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Throwable ex) {
        log.warn("[exception]");
        return ex.getMessage();
    }

    @ExceptionHandler(ServiceException.class)
    public String serviceExceptionHandler(ServiceException ex) {
        log.warn("[serviceException]");
        return ex.getMessage();
    }
}


