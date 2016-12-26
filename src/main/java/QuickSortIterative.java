import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.*;

/**
 * Quick sort implementation using iterative algorithm.
 * <ul>
 * <li>uses Stack to replace recursion</li>
 * <li>faster than recursive algorithm</li>
 * </ul>
 * <p>
 * See http://javarevisited.blogspot.cz/2016/09/iterative-quicksort-example-in-java-without-recursion.html.
 *
 * @since 2016-12-26
 */
public class QuickSortIterative {

    public static void main(String args[]) {
        Integer[] unsorted = {34, 32, 43, 12, 11, 32, 22, 21, 32};

        System.out.println("Unsorted array : " + Arrays.toString(unsorted));
        iterativeQuickSort(unsorted);
        System.out.println("Sorted array : " + Arrays.toString(unsorted));
    }

    private static void iterativeQuickSort(Integer[] numbers) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(numbers.length);

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }

            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);
            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);
        }
    }

    private static int partition(Integer[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);
        while (l < h) {
            if (input[l] < piv) {
                l++;
            } else if (input[h] >= piv) {
                h--;
            } else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if (input[h] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
