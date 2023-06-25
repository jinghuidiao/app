package com.app.exception;

import com.app.common.CommonException;
import com.app.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class Exception {

    @ExceptionHandler(CommonException.class)
    public R comexception(CommonException commonException){
        return R.error(commonException.getMessage());
    }
}
