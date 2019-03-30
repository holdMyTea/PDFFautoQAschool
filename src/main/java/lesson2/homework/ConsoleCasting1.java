package lesson2.homework;

import java.util.Scanner;

public class ConsoleCasting1 {
    public static void main(String[] args) {
        char c;
        System.out.print("Input a char: ");
        Scanner s = new Scanner(System.in);
        c = s.next().charAt(0);
        System.out.println("You've inputted: " + (int) c);
    }
}
