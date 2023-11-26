import java.util.Random;
import java.util.Scanner;

public class partA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number to test (or type 'exit' to quit):");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) break;
            int n = Integer.parseInt(input);
            System.out.println(Test(n));
        }
    }

    public static String Test(int n) {
        if (n <= 1 || n == 4) return "composite";
        if (n <= 3) return "inconclusive";

        int k = 0;
        int q = n - 1;
        while (q % 2 == 0) {
            k++;
            q /= 2;
        }

        Random rand = new Random();
        int a = 2 + rand.nextInt(n - 4);

        int x = (int) Math.pow(a, q) % n;
        if (x == 1 || x == n - 1) return "inconclusive";

        for (int j = 0; j < k; j++) {
            x = (x * x) % n;
            if (x == n - 1) return "inconclusive";
        }

        return "composite";
    }
}