/**
 * 
 */
package com.example.demo.services.error.manufacturer;

/**
 * @author aditya
 *
 */

public class ManufactuerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManufactuerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ManufactuerNotFoundException(String message) {
		super(message);
	}

}
