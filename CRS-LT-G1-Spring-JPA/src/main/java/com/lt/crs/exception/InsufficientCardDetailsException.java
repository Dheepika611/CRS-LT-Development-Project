package com.lt.crs.exception;

/**
 * @author G1
 *
 */
public class InsufficientCardDetailsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientCardDetailsException(String msg){
		super(msg);
	}
}
