package com.openclassrooms.mddapi.Exception;

public class SubscriptionAlreadyExistsException  extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubscriptionAlreadyExistsException(String message) {
		super(message);
	}
}
