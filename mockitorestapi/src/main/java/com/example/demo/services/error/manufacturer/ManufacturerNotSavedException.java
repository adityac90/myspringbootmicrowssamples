/**
 * 
 */
package com.example.demo.services.error.manufacturer;

/**
 * @author aditya
 *
 */
public class ManufacturerNotSavedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManufacturerNotSavedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ManufacturerNotSavedException(String message) {
		super(message);
	}

}
