package oop24;

import java.util.Scanner;

import lab1.Data;

public class Mathematique {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("Write your a-side: ");
		int a  = sc.nextInt();
		System.out.println(Math.pow(a, 2));
		System.out.println(a * Math.sqrt(2));
		System.out.println(4 * a);
		sc.close();
	}
}
