package oop24.practice3.problem2;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<Person> people = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить нового человека");
            System.out.println("2. Показать всех людей");
            System.out.println("3. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.println("Введите тип (1 - Person, 2 - Student, 3 - Staff): ");
                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Введите имя:");
                String name = scanner.nextLine();

                System.out.println("Введите адрес:");
                String address = scanner.nextLine();

                if (type == 1) {
                    people.add(new Person(name, address));
                } else if (type == 2) {
                    System.out.println("Введите программу:");
                    String program = scanner.nextLine();

                    System.out.println("Введите год:");
                    int year = scanner.nextInt();

                    System.out.println("Введите оплату:");
                    double fee = scanner.nextDouble();

                    people.add(new Student(name, address, program, year, fee));
                } else if (type == 3) {
                    System.out.println("Введите школу:");
                    String school = scanner.nextLine();

                    System.out.println("Введите зарплату:");
                    double pay = scanner.nextDouble();

                    people.add(new Staff(name, address, school, pay));
                }
            } else if (choice == 2) {
                for (Person p : people) {
                    System.out.println(p);
                }
            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }
}
