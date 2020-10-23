package main;

public class Cat extends Animal {
	
	public Cat(String name) {
		super(name);
	}
	
	@Override
	public void sound() {
		System.out.println("야옹");

	}

	@Override
	public void behavior() {
		System.out.println("나무를 오르다");
	}
	
	 
}
