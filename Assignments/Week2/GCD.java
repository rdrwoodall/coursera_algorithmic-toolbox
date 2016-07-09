import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static long gcdEfficient(long num1, long num2) {
        if (num2 == 0) {
            return num1;
        }

        long remainder = num1 % num2;
        return gcdEfficient(num2, remainder);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcdEfficient(a, b));
    }
}