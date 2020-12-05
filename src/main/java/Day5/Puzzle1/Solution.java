package Day5.Puzzle1;

import Day5.GenericSolution;

import java.util.Arrays;
import java.util.List;

public class Solution extends GenericSolution {

    public static void main(String[] args){
        GenericSolution solution = new Solution();

        System.out.println(solution.solve());;
    }

    @Override
    protected long chooseAnswer(int[] seatNumbers){
        Arrays.sort(seatNumbers);
        return seatNumbers[seatNumbers.length - 1];
    }
}
