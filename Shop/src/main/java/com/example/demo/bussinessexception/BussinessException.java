package com.example.demo.bussinessexception;


public class BussinessException extends RuntimeException{
 private static final long serialVersionUID = 1L;
    /**
	 * 
	 */
	String code;
    String message;
    
	public BussinessException(String code,BussinessExceptionEnum bussinessExceptionEnum) {
		this.code = code;
		this.message = bussinessExceptionEnum.getMessage(); ;
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
