package com.infy.order.exception;

public class OrderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = null;

	public OrderException() {

		super();

	}

	public OrderException(String message) {
		super(message);
		this.message = message;

	}

	public OrderException(Throwable message) {
		super(message);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
