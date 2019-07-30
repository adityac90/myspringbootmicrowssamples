package org.cts.pojo;

public abstract class Singleton {
	/* private Prototype prototype; */

	protected abstract Prototype createPrototype();

	/*
	 * public Singleton(Prototype prototype) {
	 * 
	 * this.prototype = prototype; }
	 * 
	 * public void doSomething() {
	 * 
	 * prototype.foo(); }
	 * 
	 * public void doSomethingElse() {
	 * 
	 * prototype.bar(); }
	 */

	public void doSomethingMod() {

		createPrototype().foo();
	}

	public void doSomethingElseMod() {

		createPrototype().bar();
	}

}
