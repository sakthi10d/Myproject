package com.example.rabbitmqpro.model;

public class CustomMessage {


    private int messageId;
	private String message;
	
    public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "CustomMessage [messageId=" + messageId + ", message=" + message + "]";
	}

}
