package Day5;

import Common.FileLoader;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public abstract class GenericSolution {
    private static final File f = new File("src/main/java/Day5/data.txt");
    private static final Set<Character> BIG = new HashSet<>(Arrays.asList('B', 'R'));
    private static final Set<Character> SMALL = new HashSet<>(Arrays.asList('F', 'L'));

    public long solve(){
        Stream<String> lines = FileLoader.loadFile(f);

        int[] seatNumbers = lines
                .mapToInt(GenericSolution::getSeatNumber)
                .toArray();

        return this.chooseAnswer(seatNumbers);
    }

    private static int getSeatNumber(String s){
        String row = s.substring(0, 7);
        String col = s.substring(7, 10);

        int rowNumber = binaryPartition(row, 0, 127);
        int columnNumber = binaryPartition(col, 0, 7);

        return (rowNumber * 8) + columnNumber;
    }

    private static int binaryPartition(String s, int low, int high){
        if(low == high || s.isEmpty()){
            return low;
        } else {
            char c = s.charAt(0);
            if(BIG.contains(c)){
                low = (int)Math.ceil(getMidpoint(low, high));
            } else if(SMALL.contains(c)){
                high = (int)Math.floor(getMidpoint(low, high));
            }

            return binaryPartition(s.substring(1), low, high);
        }
    }

    protected static float getMidpoint(int a, int b){
        return (a + b) / 2f;
    }

    protected abstract long chooseAnswer(int[] seatNumbers);
}
