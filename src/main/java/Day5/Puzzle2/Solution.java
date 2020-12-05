package Day5.Puzzle2;

import Day5.GenericSolution;

import java.util.Arrays;

public class Solution extends GenericSolution {

    public static void main(String[] args){
        GenericSolution solution = new Solution();

        System.out.println(solution.solve());;
    }

    @Override
    protected long chooseAnswer(int[] seatNumbers){
        Arrays.sort(seatNumbers);
        for(int i = 0; i < seatNumbers.length - 1; i++){
            if(seatNumbers[i] + 1 != seatNumbers[i + 1]){
                return seatNumbers[i] + 1;
            }
        }
        throw new RuntimeException("No solution found");
    }
}
