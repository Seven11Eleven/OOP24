package oop24.practice4.problem1;

import java.util.Vector;

public class TestShapes {
    public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<>();

        shapes.add(new Circle(1, Shape.Color.RED, 5.0));
        shapes.add(new Rectangle(2, Shape.Color.GREEN, 4.0, 6.0));
        shapes.add(new Triangle(3, Shape.Color.BLUE, 3.0, 4.0));

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

