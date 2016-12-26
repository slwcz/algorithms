import java.util.Arrays;

/**
 * Quick sort implementation using recursive algorithm.
 * <p>
 * <ul>
 * <li>on average quick sort is a O(n log n) algorithm, while it's worst case is O(n^2)</li>
 * </ul>
 * <p>
 * <p/>
 * See http://javarevisited.blogspot.cz/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html.
 *
 * @since 2016-12-16
 */
public class QuickSortResursion {

    private int input[];
    private int length;

    public static void main(String args[]) {
        int[] unsorted = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Unsorted array :" + Arrays.toString(unsorted));

        QuickSortResursion sort = new QuickSortResursion();
        sort.quickSort(unsorted);

        System.out.println("Sorted array :" + Arrays.toString(unsorted));
    }

    private void quickSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }

        this.input = numbers;
        this.length = numbers.length;
        this.quickSort(0, length - 1);
    }


    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // pivot is middle index
        int pivot = input[low + (high - low) / 2];

        // Divide into two arrays
        while (i <= j) {
            while (input[i] < pivot) {
                i++;
            }

            while (input[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }

        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}