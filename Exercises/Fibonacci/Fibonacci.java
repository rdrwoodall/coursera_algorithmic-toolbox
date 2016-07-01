import java.util.*;
import java.util.concurrent.TimeUnit;

public class Fibonacci {
	private static final int[] FIBONACCI_VALUES = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
    private static final int FIBONACCI_MAX = FIBONACCI_VALUES.length - 1;
    private static final long MAX_TEST_TIME = 15000;

    static int fibonacciNaive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
    }

    static int fibonacciEfficient(int n) {
        if (n == 0) {
            return 0;
        }

        int[] fibonacciValues = new int[n + 1]; // plus one for the element 0
        fibonacciValues[0] = 0;
        fibonacciValues[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacciValues[i] = fibonacciValues[i - 1] + fibonacciValues[i - 2];
        }

        return fibonacciValues[n];
    }

    private static void executeStressTest() {
        StopWatch clock2 = new StopWatch();

        while (TimeUnit.MILLISECONDS.convert(clock2.elapsedTime(), TimeUnit.NANOSECONDS) < MAX_TEST_TIME) {
            Random random = new Random();
            int value = random.nextInt((FIBONACCI_MAX - 0) + 1) + 0;

            int expected = FIBONACCI_VALUES[value];
            int naive = fibonacciNaive(value);
            int efficient = fibonacciEfficient(value);

            System.out.println("Value: " + value);
            System.out.println("Expected: " + expected);
            System.out.println("Naive: " + naive);
            System.out.println("Efficient " + efficient);

            if (efficient != naive) {
                System.out.println("Wrong, exiting...\n");
                break;
            }

            System.out.println("Correct!\n");

            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void execute() {
        int value = 25;

        StopWatch clock = new StopWatch();
        int naive = fibonacciNaive(value);
        long executionTime = clock.elapsedTime();
        System.out.println("Naive value -> " + naive);
        System.out.println("Naive execution of fibonacci(" + value + ") -> " + executionTime + " nanoseconds\n");

        StopWatch clock2 = new StopWatch();
        int efficient = fibonacciEfficient(value);
        executionTime = clock2.elapsedTime();
        System.out.println("Efficient value -> " + efficient);
        System.out.println("Efficient execution of fibonacci(" + value + ") -> " + executionTime + " nanoseconds\n");
    }

    public static void main(String[] args) {
        // Stress Test
        executeStressTest();

        // One actual run for verification
        execute();
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