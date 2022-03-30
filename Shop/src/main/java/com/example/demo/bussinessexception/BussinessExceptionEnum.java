package com.example.demo.bussinessexception;

public enum BussinessExceptionEnum {
 
	ID_NOT_FOUND("This student id is not available"),
 	PRODUCT_NOT_FOUND("The prodduct for the given price id not available");
	
	
    String code;
    String message;
    
    BussinessExceptionEnum(String message) {
	   this.message = message;
	   
    }
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
