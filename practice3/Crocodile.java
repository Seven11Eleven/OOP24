package oop24.practice3;

public class Crocodile extends Animal {
	@Override
	public void sound() {
		System.out.println("звук который издает крокодил");
	}
	
	public void eatFood(String food, int count) {
	    String suffix;
	    if (count % 10 == 1 && count % 100 != 11) {
	        suffix = "кусок"; 
	    } else if ((count % 10 >= 2 && count % 10 <= 4) && (count % 100 < 10 || count % 100 >= 20)) {
	        suffix = "куска"; 
	    } else {
	        suffix = "кусков"; 
	    }

	    System.out.printf("Крокодил съел %d %s %s%n", count, suffix, food);
	}
	
	 public void parentSound() {
	        super.sound();
	    }	
	 public Crocodile(String name) {
	        super(name);
	        System.out.println("Создан крокодльчик по имени: " + name);
	    }
}
