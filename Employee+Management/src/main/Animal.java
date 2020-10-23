package main;

public abstract class Animal {
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void name() {
		System.out.println();
	}
	
	public abstract void sound();
	public abstract void behavior();
}
