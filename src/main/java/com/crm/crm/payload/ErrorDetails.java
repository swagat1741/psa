package com.crm.crm.payload;

import java.util.Date;

import org.springframework.web.context.request.WebRequest;

public class ErrorDetails {
	private Date date;
	private String request;
	public String getRequest() {
		return request;
	}
	public Date getDate() {
		return date;
	}
	public String getMsg() {
		return msg;
	}
	private String msg;
	public ErrorDetails(Date date, String msg,String request) {
		this.request=request;
		this.date = date;
		this.msg = msg;
	}

}
