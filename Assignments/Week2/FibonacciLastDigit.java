import java.util.*;
import java.util.concurrent.TimeUnit;

public class FibonacciLastDigit {
	private static final long MAX_TEST_TIME = 15000; // ms
    private static final int FIBONACCI_MAX = 10000000;
    private static final String RUN_STRESS_TEST_PARAM = "-t";

    private static int getFibonacciLastDigit(int n) {
    	if (n <=1) {
            return n;
        }

        int[] fib = new int[n + 1]; // plus 1 since including 0th element

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 10; // store number's last digit
        }

        return fib[n];
    }
    
    public static void main(String[] args) {
    	if (args.length > 0 && args[0].equals(RUN_STRESS_TEST_PARAM)) {
            stressTest();
            System.out.println("\nTest Complete! Input a number 0-" + FIBONACCI_MAX + " for final output verification...\n");
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }

    private static void stressTest() {
        StopWatch clock2 = new StopWatch();

        while (TimeUnit.MILLISECONDS.convert(clock2.elapsedTime(), TimeUnit.NANOSECONDS) < MAX_TEST_TIME) {
            Random random = new Random();
            int value = random.nextInt((FIBONACCI_MAX - 0) + 1) + 0;

            int lastDigit = getFibonacciLastDigit(value);            
			System.out.println("Last digit of fib(" + value + "): " + lastDigit);

            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    static class StopWatch {
        private final long start;

        StopWatch() {
            start = System.nanoTime();
        }

        public long elapsedTime() {
            long now = System.nanoTime();
            return (now - start); // return time in nanoseconds
        }
    }
}

