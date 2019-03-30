package lesson2.lecture;

public class TypeExample {

    public static void main(String[] args) {
        int i = 8760000;
        char c = (char) i;
        System.out.println(c);

        float f = 74.587384f;
        c = (char) f;
        System.out.println(c);

        i = c;
        System.out.println(i);
    }
}
