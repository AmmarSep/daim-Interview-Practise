package Fresher;

/**
 * This class demonstrates different approaches to check if a number is prime
 * A prime number is a natural number greater than 1 that has no positive divisors
 * other than 1 and itself
 */
public class PrimeNumberChecker {

    // Basic approach - check all numbers from 2 to n-1
    public static boolean isPrimeBasic(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Optimized approach - check only up to square root of n
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to find all prime numbers up to n using Sieve of Eratosthenes
    public static void printPrimesUpTo(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        System.out.print("Prime numbers up to " + n + ": ");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 3, 4, 5, 17, 25, 29, 97, 100};

        System.out.println("=== Prime Number Checker ===");
        System.out.println("Testing different approaches:\n");

        for (int num : testNumbers) {
            boolean basicResult = isPrimeBasic(num);
            boolean optimizedResult = isPrimeOptimized(num);

            System.out.println("Number: " + num);
            System.out.println("  Basic approach: " + (basicResult ? "Prime" : "Not Prime"));
            System.out.println("  Optimized approach: " + (optimizedResult ? "Prime" : "Not Prime"));
            System.out.println("  Results match: " + (basicResult == optimizedResult));
            System.out.println();
        }

        // Performance comparison
        System.out.println("=== Performance Comparison ===");
        int largeNumber = 1009; // A large prime number

        long startTime = System.nanoTime();
        boolean basicResult = isPrimeBasic(largeNumber);
        long basicTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean optimizedResult = isPrimeOptimized(largeNumber);
        long optimizedTime = System.nanoTime() - startTime;

        System.out.println("Checking if " + largeNumber + " is prime:");
        System.out.println("Basic approach: " + basicTime + " ns");
        System.out.println("Optimized approach: " + optimizedTime + " ns");
        System.out.println("Speedup: " + (double)basicTime/optimizedTime + "x");
        System.out.println();

        // Show prime numbers up to 50
        printPrimesUpTo(50);
    }
}