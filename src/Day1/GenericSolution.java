package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class GenericSolution {
    private static final File f = new File("src/Day1/Problem.txt");

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

    public abstract void solve(int[] numbers);
}
