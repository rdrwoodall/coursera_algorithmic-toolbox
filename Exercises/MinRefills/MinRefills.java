/*

Input:
	- a car which can travel at most L kilometers with full tank, 
	- source point A, 
	- destination point B 
	- n gas stations at distances x1 <= x2 <= x3 <= ... <= xn

Output:
	- minimum number of refills to get from A to B besides refill at A.

*/

public class MinRefills {
	private static final int IMPOSSIBLE = -1;

	public static int minRefills(int[] stations, int capacity) {
		int refills = 0;
		int currentRefill = 0; // store index of where refill occurs
		int lastRefill = 0;	   // store distance from start of where last refill occured

		while (currentRefill < stations.length - 1) {
			// Not enough capacity to reach the next station
			if ((stations[currentRefill + 1] - stations[currentRefill]) > capacity) {
				return IMPOSSIBLE;
			}


			// If next station's distance exceeds distance from last refill plus capacity
			// refill at current station
			if (stations[currentRefill + 1] > (lastRefill + capacity)) {
				lastRefill = stations[currentRefill];
				refills++;
			}

			currentRefill++;
		}

		return refills;
	}

	public static void main(String[] args) {
		// set size always includes A and B
		int[] sample = {0, 200, 375, 550, 750, 950};

		System.out.println(minRefills(sample, 400));
	}
}