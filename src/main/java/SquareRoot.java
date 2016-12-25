/**
 * Uses binary search to find the square root of given input.
 * See http://javarevisited.blogspot.cz/2016/10/how-to-find-square-root-of-number-in-java-algorithm.html.
 *
 * @since 2016-12-25
 */
public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }

    private static float sqrt(int number) {
        if (number < 0) {
            return -1;
        }

        if (number == 0 || number == 1) {
            return number;
        }

        // Ranges for the initial/full interval
        float start = 0.0f;
        float end = number;

        float precision = 0.001f;
        float middle = start;

        // Calculate initial difference
        float difference = (float) Math.abs(Math.pow(middle, 2) - number);

        // Repeat till the difference between input and power of two of our intermediate result is bigger than the precision
        while (difference >= precision) {
            // Middle value of our current interval
            middle = (start + end) / 2.0f;

            if (Math.pow(middle, 2) > number) {
                // The result is in the lower half of our current interval
                end = middle;
            } else {
                // The result is in the upper half of our current interval
                start = middle;
            }

            difference = (float) Math.abs(Math.pow(middle, 2) - number);
        }

        // If the power of two of the middle value is lower than the precision defined, we are done.
        return middle;
    }
}
