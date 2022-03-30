package com.example.demo.ExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = IdNotFoundException.class)
       public ResponseEntity <CustomerErrorResponse> idNotFoundException(Exception e) {
        CustomerErrorResponse error = new CustomerErrorResponse("DETAILS_NOT_Found","Wrong Id Entered");
        error.setErrortiming(LocalDateTime.now());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }   
    @ExceptionHandler(value = ExitByProductPriceException.class)
    public ResponseEntity<CustomerErrorResponse> productNotFoundException(Exception ep){
    	CustomerErrorResponse response = new CustomerErrorResponse("DETAILS_NOT_FOUND","PRICE NOT FOUND");
    	response.setErrortiming(LocalDateTime.now());
    	response.setStatus((HttpStatus.METHOD_NOT_ALLOWED.value()));
    	return new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
    }
    }
    


