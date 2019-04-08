package lesson2.homework;

public class Math4 {
    public static void main(String[] args) {
        int n = 374;
        System.out.println("The sum of digits of "+n+" is "+(
                n/100 + (n%100/10) + n%10
        ));
    }
}
