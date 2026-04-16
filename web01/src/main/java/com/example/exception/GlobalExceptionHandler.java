package com.example.exception;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result handleException(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage(),e);
        return Result.error("服务器异常");
    }
}
