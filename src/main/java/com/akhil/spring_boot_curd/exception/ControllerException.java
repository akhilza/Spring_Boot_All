package com.akhil.spring_boot_curd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorEntity> notFoundException(NotFoundException notFoundException, WebRequest webRequest){
        ErrorEntity errorEntity=new ErrorEntity(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                notFoundException.getMessage(),
                webRequest.getDescription(false));

  return new ResponseEntity<>(errorEntity,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorEntity> globleExceptionHandler(Exception exception, WebRequest webRequest){
        ErrorEntity errorEntity=new ErrorEntity(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),

                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false));

        return new ResponseEntity<>(errorEntity,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
