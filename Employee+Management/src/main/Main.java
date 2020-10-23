package main;

public class Main {
	public static void main(String[] args) {
		Cat cat = new Cat("고양이");
		Dog dog = new Dog("개");
		Bird bird = new Bird("참새");
		
		bird.sound();
		cat.sound();
		dog.sound();
		System.out.println();
		
		bird.behavior();
		dog.behavior();
		cat.behavior();
		System.out.println();
		
		System.out.println(bird.getName());
		System.out.println(dog.getName());
		System.out.println(cat.getName());
	}
}
