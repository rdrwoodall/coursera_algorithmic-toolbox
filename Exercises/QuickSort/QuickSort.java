public class QuickSort {
	private static void swap(int[] arr, int indexA, int indexB) {
        System.out.print("\tswapping " + arr[indexA] + " and " + arr[indexB]);

        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;

        System.out.println(" - > " + Arrays.toString(arr));
    }

    private static void printSubArray(int[] arr, int low, int high) {
        System.out.print("[");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + (i == (high) ? "]" : ", "));
        }

        if (high <= 0 || high < low) {
            System.out.print("]");
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = arr[low];

        System.out.print("partition(");
        printSubArray(arr, low, high);
        System.out.println(", " + low + ", " + high + ")");
        System.out.println("\tpivotValue: " + v);

        while (true) {
            // incrementing through array
            // find first item that is not
            // less than or equal to v,
            // the value of i will be
            // the index that needs to be moved
            // to the right of the pivot value
            while (arr[++i] <= v) {
                if (i == high)
                    break;
            }

            // decrementing through array
            // find first item that is not
            // greater than v,
            // the value of j will be
            // the index that needs to be moved
            // to the left of the pivot value
            while (arr[--j] > v) {
                if (j == low)
                    break;
            }

            if (i >= j) {
                System.out.println("\tindex pointers crossed, values split on pivotValue.");
                break;
            }

            swap(arr, i, j);
        }

        // swap values at j and lo (which was selected pivot)
        System.out.println("\tmoving pivot into place...");
        swap(arr, low, j);

        return j;
    }

    private static void sort(int[] arr, int low, int high) {
        System.out.print("\nsort(");
        printSubArray(arr, low, high);
        System.out.println(", " + low + ", " + high + ")");

        if (high <= low) { // already sorted
            System.out.println("base case reached for low(" + low + ") and high(" + high + ").");
            return;
        }

        /*
            Select a pivot and sort elements
            to left and right of pivot recursively
        */

        int pivotIndex = partition(arr, low, high);
        sort(arr, low, pivotIndex - 1);
        sort(arr, pivotIndex + 1, high);
    }

    private static void sort(int[] arr) {
        // TODO: need to randomize inputs before calling sort
        sort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,8,5,9,1};

        System.out.println("unsorted: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("\nsorted: " + Arrays.toString(arr));
    }
}