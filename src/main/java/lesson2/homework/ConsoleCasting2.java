package lesson2.homework;

import java.util.Scanner;

public class ConsoleCasting2 {
    public static void main(String[] args) {
        int i;
        System.out.print("Input an integer: ");
        try (Scanner s = new Scanner(System.in)) {
            i = s.nextInt();
            System.out.println("You've inputted: " + (char) i);
        } catch (Exception e) {
            System.out.println("Not the input we've expected =(");
        }
    }
}
