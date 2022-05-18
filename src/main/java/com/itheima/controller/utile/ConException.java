package com.itheima.controller.utile;

import com.itheima.controller.utile.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ConException {

    @ExceptionHandler(Exception.class)
    public R Excep(Exception ex){
        ex.printStackTrace();

        return new R("服务器异常");
    }
}
