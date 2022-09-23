package FrequentInterviewPrograms;

public class PrimeOrNot {
    public static void main(String[] args) {
        int numpr = 15;
        int count = 0;
        if (numpr > 1) {
            for (int i = 1; i <= numpr; i++) {
                if (numpr % i == 0)
                    count++;
            }
            if (count == 2) {
                System.out.println("This number is a prime number");
            } else {
                System.out.println("This number is not a prime number");
            }
        } else {
            System.out.println("Not a prime number");
        }
    }
}

