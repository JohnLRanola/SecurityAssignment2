import java.util.Random;
import java.util.Scanner;

public class partA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // While loop to allow user to input a number to test or exit
        while (true) {
            System.out.println("Enter a number to test (or type 'exit' to quit):");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) break;
            int n = Integer.parseInt(input);
            System.out.println(Test(n));
        }
    }

    // Test method to determine if a number is prime or composite
    public static String Test(int n) {

        // if (n <= 1) or n == 4 return "composite";
        if (n <= 1 || n == 4) return "composite";

        // n is less then or equals to three it is inconclusive
        if (n <= 3) return "inconclusive";

        // Two variables, k and q, are initialized. 
        int k = 0;
        int q = n - 1;
        while (q % 2 == 0) {
            k++;
            q /= 2;
        }

        // A Random object is created, which will be used to generate random numbers.
        Random rand = new Random();

        // A random integer a is generated in the range from 2 to n-4 inclusive. 
        int a = 2 + rand.nextInt(n - 4);

        // The variable x is calculated as a to the power of q, modulo n. 
        int x = modPow(a, q, n);

        if (x == 1 || x == n - 1) return "inconclusive";

        for (int j = 0; j < k; j++) {
            x = (x * x) % n;
            if (x == n - 1) return "inconclusive";
        }

        return "composite";
    }

    // Modular exponentiation method
    public static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent >>= 1;
        }
        return result;
    }
}