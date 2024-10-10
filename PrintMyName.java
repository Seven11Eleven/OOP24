package oop24;

import java.util.Formatter;
import java.util.Scanner;

public class PrintMyName {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.println("Write your name: ");
		String name = sc.nextLine();
		
		Formatter f = new Formatter();
		f.format("+---+\n|%s|\n+---+", name);
		System.out.print(f);
		sc.close();
	}
}
