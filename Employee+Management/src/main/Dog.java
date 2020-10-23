package main;

public class Dog extends Animal {
	
	public Dog(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println("港港");

	}
	
	@Override
	public void behavior() {
		System.out.println("晨货甫 该促");
	}

}
