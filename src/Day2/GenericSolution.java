package Day2;

import java.io.*;
import java.util.stream.Stream;

/**
 * Generic abstract class that implements annoying boilerplate parsing and stuff.
 */
public abstract class GenericSolution {
    private static final File f = new File("src/Day2/data.txt");

    /**
     * Finds the number of valid entries according to the implementation of {@link GenericSolution#validateEntry(Entry)}.
     * @return the number of valid entries
     */
    public long solve(){
        Stream<String> inputLines = this.loadFile();

        return inputLines
                .map(GenericSolution::parseInputLine)
                .filter(this::validateEntry)
                .count();
    }

    /**
     * Loads the lines of the {@link File} <code>f</code> and returns it as a stream of {@link String}s.
     * @return the lines of <code>f</code>
     */
    private Stream<String> loadFile(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(f));
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

        return reader.lines();
    }

    private static Entry parseInputLine(String s){
        String[] splitData = s.split(" ");
        int minimum = Integer.parseInt(splitData[0].split("-")[0]);
        int maximum = Integer.parseInt(splitData[0].split("-")[1]);
        char targetChar = splitData[1].charAt(0);
        String password = splitData[2];
        return new Entry(minimum, maximum, targetChar, password);
    }

    /**
     * Validate the entry according to the puzzle's arbitrary rules.
     * @param entry the entry to validate
     * @return <code>true</code> if the entry is valid, <code>false</code> otherwise
     */
    protected abstract boolean validateEntry(Entry entry);

    protected static class Entry {
        private int first;
        private int second;
        private char requiredLetter;
        private String password;

        public Entry(int first, int second, char requiredLetter, String password){
            this.first = first;
            this.second = second;
            this.requiredLetter = requiredLetter;
            this.password = password;
        }

        public int getFirst(){
            return first;
        }

        public int getSecond(){
            return second;
        }

        public char getRequiredLetter(){
            return requiredLetter;
        }

        public String getPassword(){
            return password;
        }
    }
}
