package com.example.demo.bussinessexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.ExceptionHandler.CustomerErrorResponse;
@ControllerAdvice
public class ExceptionControllerAdvice {
	 @ExceptionHandler(value = BussinessException.class)
     public ResponseEntity <CustomerErrorResponse> bussinessException(BussinessException e) {
      CustomerErrorResponse bussiness = new CustomerErrorResponse(e.getCode(),e.getMessage());
      bussiness.setErrortiming(LocalDateTime.now());
      bussiness.setStatus((HttpStatus.NOT_FOUND.value()));
      return new ResponseEntity<>(bussiness, HttpStatus.NOT_FOUND);
  }   
}
