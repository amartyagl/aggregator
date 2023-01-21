package com.globallogic.advice;

import com.globallogic.exception.PostNotExist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostNotExist.class)
    public Map<String, String> handlePostNotExist(PostNotExist exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("no post exist in database");
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleParentException(Exception exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("Some error occurred {}", exception.getMessage());
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }

}
