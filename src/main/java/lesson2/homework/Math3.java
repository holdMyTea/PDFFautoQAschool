package lesson2.homework;

public class Math3 {
    public static void main(String[] args) {
        double n = 13.38673498738;
        int casted = (int) n;
        int closest = n >= casted+0.5 ? casted+1 : casted;
        System.out.println("Closest integer value of "+n+" is "+closest);
    }
}
