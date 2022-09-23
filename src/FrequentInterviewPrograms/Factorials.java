package FrequentInterviewPrograms;

public class Factorials {
    public static void main(String[] args) {
        int factorialFor = 6;
        int factorial = 1;
        for(int i=1; i<=factorialFor; i++){
            factorial = factorial*i;
        }
        System.out.println(factorial);
    }

}
