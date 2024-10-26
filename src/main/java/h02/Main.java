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
        org.tudalgo.algoutils.student.Student.crash("H2.3 - Remove if implemented");
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
        org.tudalgo.algoutils.student.Student.crash("H2.3 - Remove if implemented");
    }

    /**
     * Perform sanity checks for exercise H2.2
     */
    @StudentImplementationRequired("H2.3")
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

        // TODO: H2.3
        org.tudalgo.algoutils.student.Student.crash("H2.3 - Remove if implemented");
    }

}
