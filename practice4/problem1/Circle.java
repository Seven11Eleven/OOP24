package oop24.practice4.problem1;

public class Circle extends Shape {
 private double radius;

 public Circle(int position, Color color, double radius) {
     super(position, color);
     this.radius = radius;
 }

 @Override
 public void draw() {
     System.out.println("Drawing Circle at position: " + position + " with color: " + color + " and radius: " + radius);
 }

 public double getRadius() {
     return radius;
 }

 public void setRadius(double radius) {
     this.radius = radius;
 }
}





