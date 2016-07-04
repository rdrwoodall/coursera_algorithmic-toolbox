public class GreatestCommonDivisor {
	static long gcdEfficient(long num1, long num2) {
		if (num2 == 0) {
			return num1;
		}

		long remainder = num1 % num2;
		return gcdEfficient(num2, remainder);
	}

	public static void main(String[] args) {
		System.out.println("gcd(3918848, 1653264) -> " + gcdEfficient((long) 3918848, (long) 1653264));
	}

	static class StopWatch {
		private final long start;

		StopWatch() {
			start = System.nanoTime();
		}

		// elapsed time in nanoseconds
		public long elapsedTime() {
			return System.nanoTime() - start;
		}
	}
}