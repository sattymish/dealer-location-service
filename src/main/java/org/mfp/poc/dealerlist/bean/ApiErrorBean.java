/**
 * 
 */
package org.mfp.poc.dealerlist.bean;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Sangeeta
 *
 */
public class ApiErrorBean {
	
	private HttpStatus status;
    private String message;
    

    public ApiErrorBean(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
     
    }


	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}



}
