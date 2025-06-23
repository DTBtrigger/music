package com.music.demo.common.handler;

import com.music.demo.common.exception.user.UserCredentialsException;
import com.music.demo.common.exception.user.UsernameEmptyException;
import com.music.demo.common.exception.user.UsernameNotFoundException;
import com.music.demo.common.result.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UsernameExceptionHandler {
    @ExceptionHandler(UsernameEmptyException.class)
    public HttpResult<String> usernameEmptyException(UsernameEmptyException e) {
        log.error(e.getMessage());
        return HttpResult.failed(e.getMessage());
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public HttpResult<String> usernameNotFoundException(UsernameNotFoundException e) {
        log.error(e.getMessage());
        return HttpResult.failed(e.getMessage());
    }
    @ExceptionHandler(UserCredentialsException.class)
    public HttpResult<String> usernameCredentialsException(UserCredentialsException e) {
        log.error(e.getMessage());
        return HttpResult.failed(e.getMessage());
    }
}
