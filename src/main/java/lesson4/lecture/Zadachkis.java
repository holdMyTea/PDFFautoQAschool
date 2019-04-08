package lesson4.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadachkis {

    public static void main(String[] args) {

    }

    private void number1() {
        int min = Integer.MAX_VALUE;
        System.out.println("Input 4 numbers");
        int current;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
            System.out.print("Input "+i+"number: ");
            current = sc.nextInt();
            if (current < min) {
                min = current;
            }
        }
        System.out.println("Minimum is "+min);
    }

    private void number2() {
        List<Integer> list = new ArrayList<>(4);
        int max = Integer.MIN_VALUE;

        System.out.println("Input 4 numbers");
        Scanner sc = new Scanner(System.in);

        int current;
        for (int i = 1; i <= 4; i++) {
            System.out.print("Input "+i+"number: ");
            current = sc.nextInt();
            list.add(current);
            if (current > max) {
                max = current;
            }
        }

        int maxCount=0;
        for (int num: list) {
            if (num == max) {
                maxCount++;
            }
        }
        System.out.println("Maximum occurs "+maxCount+" times");
    }

    private void number3() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        System.out.println("Input 5 numbers");
        int current;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.print("Input "+i+"number: ");
            current = sc.nextInt();
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }

        System.out.println("Minimum is "+min);
        System.out.println("Maximum is "+max);
    }

    private void number4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first name: ");
        String s1 = sc.next();

        System.out.println("Input second name: ");
        String s2 = sc.next();

        if(s1.equals(s2)) {
            System.out.println("You are tezkas");
        } else {
            System.out.println("No relation");
        }
    }

    private void number5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inout month number: ");
    }
}
