package main;

public class Bird extends Animal {
	public Bird(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println("Â±Â±");

	}

	@Override
	public void behavior() {
		System.out.println("ÇÏ´ÃÀ» ³¯´Ù");

	}

}
