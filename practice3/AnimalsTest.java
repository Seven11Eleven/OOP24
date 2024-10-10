package oop24.practice3;

public class AnimalsTest {
	public static void main(String[] args) {
        Crocodile croco = new Crocodile("croccy-boy");
        croco.eatFood("мяса", 3);
        croco.eatFood("мясo");
        croco.eatFood("мяса", 1337);
        croco.sound();
        croco.parentSound();
	}
}
