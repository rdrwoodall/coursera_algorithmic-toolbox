import java.util.Arrays;

public class MergeSort {
	private static void merge(int[] orig, int[] temp, int low, int mid, int high) {
        // copy orig to temp
        for (int k = low; k <= high; k++) {
            temp[k] = orig[k];
        }
        
        // next set of vars determine indexes
        // of sorted arrays ('A' and 'B')
        // within temp.
        //
        // sortedA_Left  -> typically 'i'
        // sortedA_Right -> mid
        // sortedB_Left  -> typically 'j'
        // sortedB_Right -> high
        
        int sortedA_Left = low;
        int sortedA_Right = mid;
        int sortedB_Left = mid + 1;
        int sortedB_Right = high;
        
        for (int k = low; k <= high; k++) {
            if (sortedA_Left > sortedA_Right)                 orig[k] = temp[sortedB_Left++]; // used all available indexes in sortedA, use rest of indexes from sortedB
            else if (sortedB_Left > sortedB_Right)            orig[k] = temp[sortedA_Left++]; // used all available indexes in sortedB, use rest of indexes from sortedA
            else if (temp[sortedB_Left] < temp[sortedA_Left]) orig[k] = temp[sortedB_Left++]; // sortedB value is next to be merged into orig
            else                                              orig[k] = temp[sortedA_Left++]; // sortedA value is next to be merged into orig
        }
    }
    
    private static void sort(int[] orig, int[] temp, int low, int high) {
        if (high <= low) {
            return;
        }
        
        int mid = low + (high - low) / 2;
        int midPrime = (low + high) / 2;
        System.out.println("mid(" + mid + ") == midPrime(" + midPrime + "): " + (mid == midPrime));
        
        sort(orig, temp, low, mid);
        sort(orig, temp, mid + 1, high);
        merge(orig, temp, low, mid, high);
    }
    
    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {4,2,5,8,1};
        
        System.out.println("unsorted: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("sorted: " + Arrays.toString(arr));
    }
}