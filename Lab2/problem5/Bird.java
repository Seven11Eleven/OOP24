package oop24.Lab2.problem5;

public class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSound() {
        return "чик-чирик";
    }
}
