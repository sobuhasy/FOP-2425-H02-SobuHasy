package h02;

import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

/**
 * This class serves as a container for the methods that are to be implemented by the students for exercise H2.1.1.
 */
public class OneDimensionalArrayStuff {

    /**
     * Prevent instantiation of this utility class.
     */
    private OneDimensionalArrayStuff() {
        throw new IllegalStateException("This class is not meant to be instantiated.");
    }

    /**
     * Returns a new array that is a copy of the input array with the given value appended at the end.
     *
     * @param array the input array
     * @param value the value to append
     * @return a new array that is a copy of the input array with the given value appended at the end
     */
    @SuppressWarnings("ManualArrayCopy")
    @StudentImplementationRequired("H2.1.1")
    public static int[] push(final int[] array, final int value) {
        // TODO: H2.1.1
        // Creates a new array that is one element larger than the input array
        int [] newArray = new int[array.length + 1];

        // Copy all elements from the input array to the new array
        System.arraycopy(array, 0, newArray, 0, array.length);

        // Add the new value to the end of the new arrray
        newArray[array.length] = value;

        // Return the new array
        return newArray;
        // return org.tudalgo.algoutils.student.Student.crash("H2.1.1 - Remove if implemented");
    }

    /**
     * Calculates the next Fibonacci number based on the given array and returns a new array with the next Fibonacci
     * number appended at the end.
     *
     * @param array the input array containing the last two Fibonacci numbers up to the current point
     * @return a new array with the next Fibonacci number appended at the end
     */
    @StudentImplementationRequired("H2.1.1")
    public static int[] calculateNextFibonacci(final int[] array) {
        // TODO: H2.1.1
        int nextFibonacci = array[array.length - 1] + array[array.length - 2];
        return push(array, nextFibonacci);
        // return org.tudalgo.algoutils.student.Student.crash("H2.1.1 - Remove if implemented");
    }

    /**
     * Returns the n-th Fibonacci number.
     *
     * @param n the index of the Fibonacci number to return
     * @return the n-th Fibonacci number
     */
    @StudentImplementationRequired("H2.1.1")
    public static int fibonacci(final int n) {
        // TODO: H2.1.1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] fibonacciArray = {0, 1};
        for (int i = 2; i <= n; i++) {
            fibonacciArray = calculateNextFibonacci(fibonacciArray);
        }
        return fibonacciArray[fibonacciArray.length - 1];
        // return org.tudalgo.algoutils.student.Student.crash("H2.1.1 - Remove if implemented");
    }
}
