package org.cts.factory;

public class AnotherFactory {
	private static AnotherFactory anotherFactory = new AnotherFactory();

	private AnotherFactory() {

	}

//Not a static factory method
	public AnotherFactory getInstance() {
		return anotherFactory;
	}

}
