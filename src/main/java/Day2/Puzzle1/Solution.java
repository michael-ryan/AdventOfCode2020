package Day2.Puzzle1;

import Common.FileLoader;
import Day2.GenericSolution;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        GenericSolution solution = new Solution();

        System.out.println(solution.solve(FileLoader.loadFile(f)));
    }

    protected boolean validateEntry(Entry entry){
        int occurrences = countOccurrences(entry.getPassword(), entry.getRequiredLetter());
        return occurrences >= entry.getFirst() && occurrences <= entry.getSecond();
    }

    private static int countOccurrences(String string, char target){
        int occurrences = 0;

        for(char c : string.toCharArray()){
            if(c == target){
                occurrences++;
            }
        }

        return occurrences;
    }
}
