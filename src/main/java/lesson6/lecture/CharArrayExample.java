package lesson6.lecture;

public class CharArrayExample {
    public static void main(String[] args) {
        char[] arr = new char[256];
        for (int i = 0; i < 256; i++) {
            arr[i] = (char)i;
        }
        String s = new String(arr);
        System.out.println(s);
    }
}
