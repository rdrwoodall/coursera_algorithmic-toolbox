import java.util.Scanner;

public class Change {
	private static final int[] COIN_BANK = {10,5,1}; // represents 10¢, 5¢, 1¢

    private static int getChangeNaive(int m) {
        int amount = 0;
        int coinCount = 0;
        int i = 0;

        while (amount <= m && i < COIN_BANK.length) {
            if ((amount + COIN_BANK[i]) <= m) {
                amount += COIN_BANK[i];
                coinCount++;
            } else {
                i++;
            }
        }

        return coinCount;
    }

    private static int getChange(int m) {
        int totalCoinCount = 0;
        int currentCoinCoint = 0;
        int amount = 0;

        for (int coin : COIN_BANK) {
            if (coin > m) {
                continue;
            }

            currentCoinCoint = (m - amount) / coin;
            amount += currentCoinCoint * coin;
            totalCoinCount += currentCoinCoint;
        }

        return totalCoinCount;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "-t": // run stress test
                    stressTest();
                    break;
                case "-c": // run comparison of efficient and naive
                    compareAlgorithmTime();
                    break;
                default:
                    System.out.println("Invalid program argument...exiting.");
                    return;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }

    private static void compareAlgorithmTime() {
        System.out.println("Algorithm comparison, waiting for input...");
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        StopWatch timer = new StopWatch();
        int coinCount = getChangeNaive(m);
        long duration = timer.getElapsedTime();
        System.out.println(coinCount + ", naive     -> " + duration + " ns");

        StopWatch timer2 = new StopWatch();
        coinCount = getChange(m);
        duration = timer2.getElapsedTime();
        System.out.println(coinCount + ", efficient -> " + duration + " ns");

        System.out.println("Algorithm comparison complete, waiting for input to run final verification test...");
    }

    private static void stressTest() {
        System.out.println("Stress test...not yet implemented");
    }

    static class StopWatch {
        private final long start;

        StopWatch() {
            start = System.nanoTime();
        }

        public long getElapsedTime() {
            return System.nanoTime() - start;
        }
    }
}

