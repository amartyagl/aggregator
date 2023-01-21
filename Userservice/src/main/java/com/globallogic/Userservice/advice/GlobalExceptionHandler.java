package com.globallogic.Userservice.advice;

import com.globallogic.Userservice.exception.UserAlreadyExistException;
import com.globallogic.Userservice.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /* This method is for handling validations exception on different attributes */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("Error while validating input from user");
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        return errorMap;
    }

    /*
     * This method is for handling custom exception which will be thrown when user
     * try to access data which not exist in database
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleUserNotFoundException(UserNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("User not exist in database");
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }

    /*
     * This method is for handling custom exception which will be thrown when user
     * try to add same data which exist in database
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistException.class)
    public Map<String, String> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("User already exist it can not be added again");
        errorMap.put("errorMessage", exception.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(SQLException.class)
    public Map<String, String> handleSQLException(SQLException exception) {
        Map<String, String> errorMap = new HashMap<>();
        log.error("Error while getting user from database {}", exception.getMessage());
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
