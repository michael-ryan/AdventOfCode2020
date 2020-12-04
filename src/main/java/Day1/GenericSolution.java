package Day1;

import Common.FileLoader;

import java.io.*;

/**
 * Generic abstract class that implements annoying boilerplate parsing and stuff.
 */
public abstract class GenericSolution {
    private static final File f = new File("src/Day1/data.txt");
    protected static final int TARGET = 2020;

    /**
     * Loads the {@link File} <code>f</code> variable and returns it as an array of integers.
     * @return the content of <code>f</code>
     */
    protected static int[] parseProblem(){
        return FileLoader.loadFile(f)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * Finds a pair of numbers in <code>numbers</code> that adds to make <code>target</code>.
     * @param numbers the input array of numbers to work with
     * @param target the target number to find
     * @return the pair of numbers that add to make the <code>target</code>, or null if no such pair is found.
     */
    public abstract long solve(int[] numbers, int target);
}
