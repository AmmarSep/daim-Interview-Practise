package Again;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        System.out.println(" Result before swapping :" + a + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println(" Result after swapping :" + a + b);
    }
}
