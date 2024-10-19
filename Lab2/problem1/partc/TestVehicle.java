package oop24.Lab2.problem1.partc;

import java.util.HashSet;
import java.util.Set;

public class TestVehicle {
    public static void main(String[] args) {
        Set<Vehicle> vehicleSet = new HashSet<>();

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla");
        Vehicle vehicle2 = new Vehicle("Toyota", "Corolla");
        Vehicle vehicle3 = new Vehicle("Honda", "Civic");

        vehicleSet.add(vehicle1);
        vehicleSet.add(vehicle2);
        vehicleSet.add(vehicle3);

        System.out.println("Vehicles in the set:");
        for (Vehicle v : vehicleSet) {
            System.out.println(v);
        }

        System.out.println("Total vehicles: " + vehicleSet.size());

        Set<Car> carSet = new HashSet<>();
        Car car1 = new Car("Toyota", "Corolla", "ABC123");
        Car car2 = new Car("Toyota", "Corolla", "ABC123");
        Car car3 = new Car("Honda", "Civic", "XYZ789");
        Car car4 = new Car("Toyota", "Corolla", "DEF456");

        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);

        System.out.println("\nCars in the set:");
        for (Car c : carSet) {
            System.out.println(c);
        }

        System.out.println("Total cars: " + carSet.size());
    }
}
