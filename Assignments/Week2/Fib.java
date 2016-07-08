import java.util.*;
import java.util.concurrent.TimeUnit;

public class Fib {
	private static final long MAX_TEST_TIME = 15000; // ms
    private static final int FIBONACCI_MAX = 45;
    private static final String RUN_STRESS_TEST_PARAM = "-t";
    
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        return calc_fib(n - 1) + calc_fib(n - 2);
    }

    private static long calc_fib_efficient(int n) {
        if (n <=1) {
            return n;
        }

        long[] fib = new long[n + 1]; // plus 1 since including 0th element

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    public static void main(String args[]) {
        if (args.length > 0 && args[0].equals(RUN_STRESS_TEST_PARAM)) {
            stressTest();
            System.out.println("Test Complete! Input a number 0-45 for final output verification...\n");
        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib_efficient(n));
    }

    private static void stressTest() {
        StopWatch clock2 = new StopWatch();

        while (TimeUnit.MILLISECONDS.convert(clock2.elapsedTime(), TimeUnit.NANOSECONDS) < MAX_TEST_TIME) {
            Random random = new Random();
            int value = random.nextInt((FIBONACCI_MAX - 0) + 1) + 0;

            System.out.println("calculating...");

            long naive = calc_fib(value);
            long efficient = calc_fib_efficient(value);

            System.out.println("Value: " + value);
            System.out.println("Naive: " + naive);
            System.out.println("Efficient " + efficient);

            if (efficient != naive) {
                System.out.println("Error detected, exiting...\n");
                break;
            }

            System.out.println("Correct!\n");

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
