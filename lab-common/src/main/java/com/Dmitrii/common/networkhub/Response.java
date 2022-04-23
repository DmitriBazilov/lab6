package com.Dmitrii.common.networkhub;

import java.io.Serializable;

/**
 *
 * @author dmitrii
 */
public class Response implements Serializable {
	
	private String message;

	public Response(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
