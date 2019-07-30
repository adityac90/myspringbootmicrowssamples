/**
 * 
 */
package org.cts.factory;

/**
 * @author aditya
 *
 */
public class CustomBeanFactory {

	private static CustomBeanFactory customBeanFactory = new CustomBeanFactory();

	private CustomBeanFactory() {

	}

	public static CustomBeanFactory getInstance() {
		return customBeanFactory;
	}

}
