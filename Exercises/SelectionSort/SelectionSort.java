import java.util.Arrays;

public class SelectionSort {
	private static void sort(int[] list) {
		if (list.length <= 1) {
			return; // already sorted
		}

		int minIndex;

		for (int i = 0; i < list.length; i++) {
			minIndex = i;

			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[minIndex]) {
					minIndex = j;
				}
			}

			swap(list, i, minIndex);
		}
	}	

	private static void swap(int[] list, int firstIndex, int secondIndex) {
		System.out.println("swapping: " + firstIndex + " " + secondIndex);
		int temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;
	}

	public static void main(String[] args) {
		int[] list = {8,4,2,5,2};

		System.out.println("unsorted list:");
		System.out.println(Arrays.toString(list));

		sort(list);

		System.out.println("sorted list:");
		System.out.println(Arrays.toString(list));
	}
}
