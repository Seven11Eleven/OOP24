package oop24.practice3;

public class Animal {
	
	 public Animal(String name) {
	        System.out.println("Животное: " + name);
	    }
	
    public void sound() {
        System.out.println("Звук животного");
    }

    public void eatFood(String food) {
        System.out.println("Животное ест " + food);
    }
    
}
