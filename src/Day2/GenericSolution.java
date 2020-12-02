package Day2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Generic abstract class that implements annoying boilerplate parsing and stuff.
 */
public abstract class GenericSolution {
    private static final File f = new File("src/Day2/data.txt");

    /**
     * Loads the {@link File} <code>f</code> variable and returns it as an array of integers.
     * @return the content of <code>f</code>
     */
    protected static Entry[] parseProblem(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(f));
        } catch(FileNotFoundException e){
            System.out.println("File " + f.toString() + " not found.");
            System.exit(1);
            return null;
        }

        List<Entry> entries = new ArrayList<>();
        String s;
        while (true){
            try {
                if((s = reader.readLine()) == null) break;
            } catch(IOException e) {
                e.printStackTrace();
                System.exit(2);
                return null;
            }
            String[] splitData = s.split(" ");
            int minimum = Integer.parseInt(splitData[0].split("-")[0]);
            int maximum = Integer.parseInt(splitData[0].split("-")[1]);
            char targetChar = splitData[1].charAt(0);
            String password = splitData[2];
            entries.add(new Entry(minimum, maximum, targetChar, password));
        }
        return listToArray(entries);
    }

    /**
     * Filth to convert a {@link List} to an int array.
     * @param entries the list to convert
     * @return the content of the list in array form
     */
    private static Entry[] listToArray(List<Entry> entries)
    {
        Entry[] ret = new Entry[entries.size()];
        Iterator<Entry> iterator = entries.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next();
        }
        return ret;
    }

    /**
     * Finds the number of valid entries in an array.
     * @param entries the entries to check if valid
     * @return the number of valid entries
     */
    public int solve(Entry[] entries){
        int numberCorrect = 0;
        for(Entry entry : entries){
            if(this.validateEntry(entry)){
                numberCorrect++;
            }
        }
        return numberCorrect;
    }

    /**
     * Validate the entry according to the puzzle's arbitrary rules.
     * @param entry the entry to validate
     * @return <code>true</code> if the entry is valid, false otherwise
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
