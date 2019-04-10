package lesson4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasks {

    public static void main(String[] args) {
        System.out.print("Select the task: ");
        Tasks tasks = new Tasks();
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                tasks.number1();
                break;

            case 2:
                tasks.number2();
                break;

            case 3:
                tasks.number3();
                break;

            case 4:
                tasks.number4();
                break;

            case 5:
                tasks.number5();
                break;

            default:
                System.out.println("outta bounds");

        }
    }

    private void number1() {
        int min = Integer.MAX_VALUE;
        System.out.println("Input 4 numbers");
        int current;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 4; i++) {
            System.out.print("Input " + i + " number: ");
            current = sc.nextInt();
            if (current < min) {
                min = current;
            }
        }
        System.out.println("Minimum is " + min);
    }

    private void number2() {
        List<Integer> list = new ArrayList<>(4);
        int max = Integer.MIN_VALUE;

        System.out.println("Input 4 numbers");
        Scanner sc = new Scanner(System.in);

        int current;
        for (int i = 1; i <= 4; i++) {
            System.out.print("Input " + i + " number: ");
            current = sc.nextInt();
            list.add(current);
            if (current > max) {
                max = current;
            }
        }

        int maxCount = 0;
        for (int num : list) {
            if (num == max) {
                maxCount++;
            }
        }
        System.out.println("Maximum " + max + " occurs " + maxCount + " times");
    }

    private void number3() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        System.out.println("Input 5 numbers");
        int current;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.print("Input " + i + " number: ");
            current = sc.nextInt();
            if (current < min) {
                min = current;
            } else if (current > max) {
                max = current;
            }
        }

        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);
    }

    private void number4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first name: ");
        String s1 = sc.next();

        System.out.println("Input second name: ");
        String s2 = sc.next();

        if (s1.equals(s2)) {
            System.out.println("You are tezkas");
        } else {
            System.out.println("No relation");
        }
    }

    private void number5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input month number: ");
        switch (sc.nextInt()) {
            case 1:
            case 2:
            case 12:
                System.out.println("Winter");
                break;

            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;

            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;

            case 9:
            case 10:
            case 11:
                System.out.println("Fall");
                break;

            default:
                System.out.println("Outta bounds");
        }
    }
}
