package lesson6.lecture;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int buffer;
        boolean shouldBreak = true;
        for (int x:a) {
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] > a[i+1]) {
                    buffer = a[i];
                    a[i] = a[i+1];
                    a[i+1]=buffer;
                    System.out.println("lul"+i);
                    shouldBreak = false;
                }
            }
            if(shouldBreak) {
                System.out.println("GTFO");
                break;
            }
        }

        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
