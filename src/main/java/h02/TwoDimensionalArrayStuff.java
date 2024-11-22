package h02;

import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.util.Arrays;

/**
 * This class serves as a container for the methods that are to be implemented by the students for exercise H2.1.2.
 */
public class TwoDimensionalArrayStuff {

    /**
     * Prevent instantiation of this utility class.
     */
    private TwoDimensionalArrayStuff() {
        throw new IllegalStateException("This class is not meant to be instantiated.");
    }

    /**
     * Returns an array containing the number of occurrences of the query {@link String} in each line of the input array.
     *
     * @param input the input array
     * @param query the query {@link String}
     * @return an array containing the number of occurrences of the query {@link String} in each line of the input array
     */
    @StudentImplementationRequired("H2.1.2")
    public static int[] occurrences(final String[][] input, final String query) {
        // TODO: H2.1.2
        int [] result = new int[input.length];  // create an array to store the number of occurences in each line
        for (int i = 0; i < input.length; i++) {
            int count = 0; // create a counter for the number of occurances in each line
            for (String word : input[i]){       // iterate through each word in the line
                if (word.equals(query)) {    // checks if the word is equal to the query
                    count++;        // increments the counter
                }
            }
            result[i] = count; // stores the count in the result array
        }
        return result;
        // return org.tudalgo.algoutils.student.Student.crash("H2.1.2 - Remove if implemented");
    }

    /**
     * Returns the mean of the input array.
     *
     * @param input the input array
     * @return the mean of the input array
     */
    @StudentImplementationRequired("H2.1.2")
    public static float mean(final int[] input) {
        // TODO: H2.1.2
        int sum = 0; // create a variable to store the sum of the array
        for (int value : input) {
            sum += value; // sum up all the values in the array
        }
        return (float) sum / input.length; // return the mean of the array;
        // return org.tudalgo.algoutils.student.Student.crash("H2.1.2 - Remove if implemented");
    }

    /**
     * Returns the mean number of occurrences of the query {@link String} in each line of the input array.
     *
     * @param input the input array
     * @param query the query {@link String}
     * @return the mean number of occurrences of the query {@link String} in each line of the input array
     */
    @DoNotTouch
    public static float meanOccurrencesPerLine(final String[][] input, final String query) {
        return mean(occurrences(input, query));
    }

    /**
     * Overload that splits the input string by lines and spaces, then calls regular meanOccurrencesPerLine.
     *
     * @param input the input string to split by lines and spaces
     * @param query the query {@link String}
     * @return the mean number of occurrences of the query {@link String} in each line of the input array
     */
    @DoNotTouch
    public static float meanOccurrencesPerLine(final String input, final String query) {
        // filter out unwanted symbols
        final String filteredInput = input.replaceAll("[^\\w\\s]", "");
        // split by lines
        final var processedInput = Arrays.stream(filteredInput.split("(\\r\\n|\\r|\\n)"))
            // split by spaces
            .map(line -> line.split("\\s"))
            // collect to 2D array
            .toArray(String[][]::new);
        /// uncomment the following line to log processed input
        // System.out.printf("Processed input: %s%n", Arrays.deepToString(processedInput));
        // call regular meanOccurrencesPerLine
        return meanOccurrencesPerLine(processedInput, query);
    }
}
