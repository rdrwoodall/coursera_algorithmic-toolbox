import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
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

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //System.out.println(getMaxPairwiseProduct(numbers));
        System.out.println(getMaxPairwiseProductFast(numbers));
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