package lesson1.lecture;

import java.util.Scanner;

public class HelloUserConsoleInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String s = scanner.next();
        System.out.println("Greetings, "+s+"!");
    }
}
