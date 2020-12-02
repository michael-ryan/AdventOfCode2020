package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(f));
        } catch(FileNotFoundException e){
            System.out.println("File " + f.toString() + " not found.");
            System.exit(1);
            return null;
        }

        List<Integer> numbers = new ArrayList<>();
        String s;
        while (true){
            try {
                if((s = reader.readLine()) == null) break;
            } catch(IOException e) {
                e.printStackTrace();
                System.exit(2);
                return null;
            }
            numbers.add(Integer.parseInt(s));
        }
        return listToArray(numbers);
    }

    /**
     * Filth to convert a {@link List} to an int array.
     * @param integers the list to convert
     * @return the content of the list in array form
     */
    private static int[] listToArray(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next();
        }
        return ret;
    }

    /**
     * Finds a pair of numbers in <code>numbers</code> that adds to make <code>target</code>.
     * @param numbers the input array of numbers to work with
     * @param target the target number to find
     * @return the pair of numbers that add to make the <code>target</code>, or null if no such pair is found.
     */
    public abstract Pair solve(int[] numbers, int target);

    /**
     * Filth.
     */
    protected class Pair {
        private int first;
        private int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        public int getFirst(){
            return first;
        }

        public int getSecond(){
            return second;
        }
    }
}
