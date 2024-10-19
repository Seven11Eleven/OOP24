package oop24.Lab2.problem1.parta;

public class ShapesTest {
    public static void main(String[] args) {
        Shape3D cylinder = new Cylinder(5, 9);
        System.out.printf("Cylinerds volume : %s\n", cylinder.volume());
        System.out.printf("Surface Area: %s\n", cylinder.surfaceArea());

        Shape3D sphere = new Sphere(15);
        System.out.printf("sphere's volume: %s\n", sphere.volume());
        System.out.printf("sphere's surface area: %s\n", sphere.surfaceArea());

        Shape3D cube = new Cube(3);
        System.out.println("cube volume: " + cube.volume());
        System.out.println("cube surface area: " + cube.surfaceArea());
    }
}
