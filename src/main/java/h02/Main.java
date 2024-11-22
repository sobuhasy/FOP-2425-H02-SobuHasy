package h02;

import fopbot.RobotFamily;
import fopbot.World;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import static org.tudalgo.algoutils.student.io.PropertyUtils.getIntProperty;
import static org.tudalgo.algoutils.student.test.StudentTestUtils.printTestResults;
import static org.tudalgo.algoutils.student.test.StudentTestUtils.testEquals;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(final String[] args) {
        // H1
        sanityChecksH211();
        sanityChecksH212();
        printTestResults();

        // H2
        sanityChecksH22();
        printTestResults();

        // starting game (comment out if you just want to run the tests)
        final var propFile = "h02.properties";
        new FourWins(
            getIntProperty(propFile, "FW_WORLD_WIDTH"),
            getIntProperty(propFile, "FW_WORLD_HEIGHT")
        ).startGame();
    }

    /**
     * Perform sanity checks for exercise H2.1.1.
     */
    @StudentImplementationRequired("H2.3")
    public static void sanityChecksH211() {
        // TODO: H2.3
        // Test the method push with the array {0, 1} and the value 2
        int[] initialArray = {0, 1};
        int valueToAppend = 2;
        int[] expectedPushResult = {0, 1, 2};
        int[] resultArray = OneDimensionalArrayStuff.push(initialArray, valueToAppend);
        // Verify the length of the result array
        testEquals(3, resultArray.length);

        // Test the method calculateNextFibonacci with the array {0, 1}
        int[] fibonacciArray = {0, 1};
        for (int i = 0; i < 20; i++){
            fibonacciArray = OneDimensionalArrayStuff.calculateNextFibonacci(fibonacciArray);
        }
        // Verify the length of the result array
        testEquals(22, fibonacciArray.length);
        // Verify the fibonacci number at indexes 0 and 1
        testEquals(0, fibonacciArray[0]);
        testEquals(1, fibonacciArray[1]);
        // Verify the rest of the fibonacci numbers
        for (int i = 2; i < fibonacciArray.length; i++){
            testEquals(fibonacciArray[i], fibonacciArray[i-1] + fibonacciArray[i-2]);
        }

        // Test the method fibonacci with the index from 0 to 9
        int[] expectedFibonacciNumbers = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        for (int i = 0; i < expectedFibonacciNumbers.length; i++){
            testEquals(expectedFibonacciNumbers[i], OneDimensionalArrayStuff.fibonacci(i));
        }

        // org.tudalgo.algoutils.student.Student.crash("H2.3 - Remove if implemented");
    }

    /**
     * Perform sanity checks for exercise H2.1.2.
     */
    @StudentImplementationRequired("H2.3")
    public static void sanityChecksH212() {
        // predefined simple test
        final String[][] simpleTest = new String[][]{
            "a b c d e f".split(" "),
            "a b c d e f".split(" "),
            "a b c d e f".split(" "),
        };
        // predefined complex test
        final String[][] complexTest = new String[][]{
            "a a b b c c".split(" "),
            "a b c d e f".split(" "),
            "a a a b b b c c c".split(" "),
        };

        // TODO: H2.3
        // Test the method occurrences with the simple test
        String query = "b";
        int[] expectedOccurrences = {1, 1, 1};
        int[] resultOccurrences = TwoDimensionalArrayStuff.occurrences(simpleTest, query);
        // Verify the length of the result array
        testEquals(expectedOccurrences.length, resultOccurrences.length);
        // Verifying each element of the result array
        for (int i = 0; i < expectedOccurrences.length; i++){
            testEquals(expectedOccurrences[i], resultOccurrences[i]);
        }

        // Test the method mean with the simple test
        float expectedMean = 1.0f;
        testEquals(expectedMean, TwoDimensionalArrayStuff.mean(resultOccurrences));

        // Test the method occurrences with the complex test and query "b"
        int[] expectedOccurrencesComplex = {2, 1, 3};
        int[] resultOccurrencesComplex = TwoDimensionalArrayStuff.occurrences(complexTest, query);
        // Verify the length of the result array
        testEquals(expectedOccurrencesComplex.length, resultOccurrencesComplex.length);
        // Verifying each element of the result array
        for (int i = 0; i < expectedOccurrencesComplex.length; i++){
            testEquals(expectedOccurrencesComplex[i], resultOccurrencesComplex[i]);
        }

        // Test the method mean with the complex test and query "b"
        float expectedMeanComplex = 2.0f;
        testEquals(expectedMeanComplex, TwoDimensionalArrayStuff.mean(resultOccurrencesComplex));
        // org.tudalgo.algoutils.student.Student.crash("H2.3 - Remove if implemented");
    }

    /**
     * Perform sanity checks for exercise H2.2
     */
    @StudentImplementationRequired("H2.4")
    public static void sanityChecksH22() {
        // setting world size
        World.setSize(4, 5);

        // predefined stones1 array
        final RobotFamily[][] stones1 = {
            {null, RobotFamily.SQUARE_BLUE, null, RobotFamily.SQUARE_RED},
            {null, null, null, RobotFamily.SQUARE_BLUE},
            {null, null, null, RobotFamily.SQUARE_RED},
            {null, null, null, RobotFamily.SQUARE_BLUE},
            {null, null, null, RobotFamily.SQUARE_RED},
        };

        // predefined stones2 array
        final RobotFamily[][] stones2 = {
            {RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_BLUE},
            {RobotFamily.SQUARE_RED, RobotFamily.SQUARE_RED, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_RED},
            {RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_RED, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_BLUE},
            {RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_RED, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_RED},
            {RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_BLUE, RobotFamily.SQUARE_RED},
        };

        // TODO: H2.4
        // Test the method validateInput with stones1 and the columns 1 and 3
        testEquals(true, FourWins.validateInput(1, stones1));
        testEquals(false, FourWins.validateInput(3, stones1));

        // Test the method getDestinationRow with stones1 and te columns 1 and 3
        testEquals(4, FourWins.getDestinationRow(1, stones1));
        testEquals(-1, FourWins.getDestinationRow(3, stones1)); // should return -1

        // Test the method dropStone with stones1 and the column 1
        FourWins.dropStone(1, stones1, RobotFamily.SQUARE_RED);
        testEquals(RobotFamily.SQUARE_RED, stones1[4][1]);

        // Test the method testWinHorizontal with stones2
        testEquals(true, FourWins.testWinHorizontal(stones2, RobotFamily.SQUARE_BLUE));
        testEquals(false, FourWins.testWinHorizontal(stones2, RobotFamily.SQUARE_RED));

        // Test the method testWinVertical with stones2
        testEquals(true, FourWins.testWinVertical(stones2, RobotFamily.SQUARE_BLUE));
        testEquals(false, FourWins.testWinVertical(stones2, RobotFamily.SQUARE_RED));

        // Test the method testWinConditions with stones2
        testEquals(true, FourWins.testWinConditions(stones2, RobotFamily.SQUARE_BLUE));
        testEquals(false, FourWins.testWinConditions(stones2, RobotFamily.SQUARE_RED));

        // Test the method nextPlayer
        testEquals(RobotFamily.SQUARE_RED, FourWins.nextPlayer(RobotFamily.SQUARE_BLUE));
        testEquals(RobotFamily.SQUARE_BLUE, FourWins.nextPlayer(RobotFamily.SQUARE_RED));

        org.tudalgo.algoutils.student.Student.crash("H2.4 - Remove if implemented");
    }

}
