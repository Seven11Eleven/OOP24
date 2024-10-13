package oop24.practice4.problem1;

import oop24.practice4.problem1.Shape.Color;

public class Rectangle extends Shape {
	 private double width;
	 private double height;

	 public Rectangle(int position, Color color, double width, double height) {
	     super(position, color);
	     this.width = width;
	     this.height = height;
	 }

	 @Override
	 public void draw() {
	     System.out.println("Drawing Rectangle at position: " + position + " with color: " + color + " and width: " + width + " and height: " + height);
	 }

	 public double getWidth() {
	     return width;
	 }

	 public void setWidth(double width) {
	     this.width = width;
	 }

	 public double getHeight() {
	     return height;
	 }

	 public void setHeight(double height) {
	     this.height = height;
	 }
	}