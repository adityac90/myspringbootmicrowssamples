/**
 * 
 */
package com.example.demo.services.error;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

/**
 * @author aditya
 *
 */

@Component
public class ApiErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiErrorResponse() {
		super();
	}

	public ApiErrorResponse(String errorCode, String errorMsg, ZonedDateTime timeStamp) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.timeStamp = timeStamp;
	}

	private String errorCode;
	private String errorMsg;
	private ZonedDateTime timeStamp;

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

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(ZonedDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
