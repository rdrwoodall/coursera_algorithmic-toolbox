import java.util.*;
import java.math.BigInteger;

public class LCM {
  private static BigInteger lcm(int a, int b) {
        //write your code here
        BigInteger intA = new BigInteger(Integer.toString(a));
        BigInteger intB = new BigInteger(Integer.toString(b));

        BigInteger product = intA.multiply(intB);

        long gcd = gcdEfficient(a,b);
        return product.divide(BigInteger.valueOf(gcd));
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

        System.out.println(lcm(a, b));
    }
}
