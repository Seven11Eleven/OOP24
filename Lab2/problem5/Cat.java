package oop24.Lab2.problem5;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }


    @Override
    public String getSound() {
        return "Мав";
    }
}
