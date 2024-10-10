package oop24;

import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        
        String reversed = new StringBuilder(input).reverse().toString();
        
        return input.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String test = sc.nextLine();
        if (isPalindrome(test)) {
            System.out.println(test + " is a palindrome");
        } else {
            System.out.println(test + " is not a palindrome");
        }
        sc.close();
    }
}
