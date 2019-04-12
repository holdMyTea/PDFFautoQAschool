package lesson6.lecture;


public class MinMaxArray {
    public static void main(String[] args) {
        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};
        int min= Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int e:ar){
            if(e < min) {
                min = e;
            } else if(e > max) {
                max = e;
            }
        }
        System.out.println("Min is: "+min);
        System.out.println("Max is: "+max);
    }
}
