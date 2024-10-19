package oop24.Lab2.problem1.parta;

public class Cylinder extends Shape3D {
    private double radius, height;
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double volume() {
        return Math.PI * radius * radius * height; // pi * r^2 * h;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI *  radius * (height + radius);
    }
}
