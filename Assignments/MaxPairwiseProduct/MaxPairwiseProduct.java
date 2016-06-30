import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
   static final int MAX_N_VALUE = 200000;
    static final int MIN_N_VALUE = 2;
    static final int MAX_N_ITEM_VALUE = 100000;
    static final int MIN_N_ITEM_VALUE = 0;
    static final double STRESS_TEST_EXECUTION_MAX = 5.0;

    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = ((long) numbers[i]) * numbers[j];
                }
            }
        }
        return result;
    }

    static long getMaxPairwiseProductFast(int[] numbers) {
        int maxIndex1 = -1;
        int maxIndex2 = -1;

        // find index of max number in list
        for (int i = 0; i < numbers.length; ++i) {
            if (maxIndex1 == -1 ||
                    numbers[i] > numbers[maxIndex1]) {
                maxIndex1 = i;
            }
        }

        // find index of next highest number in list
        for (int j = 0; j < numbers.length; ++j) {
            if ((maxIndex2 == -1 || numbers[j] > numbers[maxIndex2]) && (j != maxIndex1)) {
                maxIndex2 = j;
            }
        }

        return ((long) (numbers[maxIndex1])) * numbers[maxIndex2];
    }

    static void execute() {
         FastScanner scanner = new FastScanner(System.in);
         int n = scanner.nextInt();
         int[] numbers = new int[n];
         for (int i = 0; i < n; i++) {
             numbers[i] = scanner.nextInt();
         }

         System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static void executeStressTest() {
        StopWatch stopwatch = new StopWatch();

        while (stopwatch.elapsedTime() < STRESS_TEST_EXECUTION_MAX) {
            // generate random n value, 2 <= n <= (2 * 10^5)  // 10^5 == 100,000
            Random randomGenerator = new Random();
            int n = randomGenerator.nextInt((10 - 2) + 1) + 2; //nextInt((MAX_N_VALUE - MIN_N_VALUE) + 1) + MIN_N_VALUE;
            System.out.println(n);
            int[] numbers = new int[n];

            // generate random values in n, 0 <= a_0,...,a_n-1 <= 10^5
            for (int i = 0; i < numbers.length; ++i) {
                numbers[i] = randomGenerator.nextInt((10 - 0) + 1) + 0;//nextInt(MAX_N_ITEM_VALUE);
                System.out.print(numbers[i] + " ");
            }
            System.out.print("\n");

            long maxPairwiseSlow = getMaxPairwiseProduct(numbers);
            long maxPairwiseFast = getMaxPairwiseProductFast(numbers);

            if (maxPairwiseSlow != maxPairwiseFast) {
                System.out.println("Wrong Answer: " + maxPairwiseSlow + " " + maxPairwiseFast);
                break;
            } else {
                System.out.println("Ok: "  + maxPairwiseSlow + " " + maxPairwiseFast);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        // Stress Test
        System.out.println("Executing stress test...");
        executeStressTest();

        // Execute regular program for final verification
        System.out.println("\n\nExecuting regular program, waiting for input...");
        execute();
    }

    static class StopWatch {
        private final long start;

        StopWatch() {
            start = System.currentTimeMillis();
        }

        public double elapsedTime() {
            long now = System.currentTimeMillis();
            return (now - start) / 1000.0; // return time in seconds
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}