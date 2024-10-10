package oop24;

import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите три числа через пробел: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int D = (b * b) - (4 * a * c);
        
        if (D < 0) {
            System.out.println("D is negative, no real roots");
        } else {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            
            System.out.printf("Первый корень: %.2f\nВторой корень: %.2f\n", x1, x2);
        }
        
        sc.close();
    }
}
