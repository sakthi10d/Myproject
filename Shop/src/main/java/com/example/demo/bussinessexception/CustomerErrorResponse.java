package com.example.demo.bussinessexception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerErrorResponse {

	String errorCode;
	String errorMsg;
	int status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime errortiming;



	public CustomerErrorResponse(String errorCode, String errorMsg) {

	//	super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
    }
    public String getErrorCode() {
	return errorCode;
	}
    public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    }
    public String getErrorMsg() {
    return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
   	this.errorMsg = errorMsg;
    }
	public int getStatus() {
    return status;
	}
	public void setStatus(int status) {
	this.status = status;
	}
	public LocalDateTime getErrortiming() {
		return errortiming;
	}
	public void setErrortiming(LocalDateTime errortiming) {
		this.errortiming = errortiming;
	}
}



