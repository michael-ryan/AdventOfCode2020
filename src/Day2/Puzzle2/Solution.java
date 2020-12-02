package Day2.Puzzle2;

import Day2.GenericSolution;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        GenericSolution solution = new Solution();

        System.out.println(solution.solve());
    }

    @Override
    protected boolean validateEntry(Entry entry){
        int numberOfCharsInPosition = 0;

        if(entry.getPassword().charAt(entry.getFirst() - 1) == entry.getRequiredLetter()){
            numberOfCharsInPosition++;
        }

        if(entry.getPassword().charAt(entry.getSecond() - 1) == entry.getRequiredLetter()){
            numberOfCharsInPosition++;
        }

        return numberOfCharsInPosition == 1;
    }
}
