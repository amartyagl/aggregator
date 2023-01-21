package com.globallogic.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.globallogic.exception.PostNotExist;
import com.mongodb.MongoException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PostNotExist.class)
    public Map<String, String> handlePostNotExistException(PostNotExist exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("Post not found");
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(MongoException.class)
    public Map<String, String> handleMongoException(MongoException exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("Error while getting post from database {}", exception.getMessage());
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
