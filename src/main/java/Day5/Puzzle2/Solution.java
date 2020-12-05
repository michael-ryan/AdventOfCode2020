package Day5.Puzzle2;

import Day5.GenericSolution;

import java.util.Arrays;

public class Solution extends GenericSolution {

    public static void main(String[] args){
        GenericSolution solution = new Solution();

        System.out.println(solution.solve());
    }

    @Override
    protected long chooseAnswer(int[] seatNumbers){
        Arrays.sort(seatNumbers);
        return seatNumbers[findFirstSeatOffIndex(seatNumbers)] - 1;
    }

    private int findFirstSeatOffIndex(int[] sortedNumbers){
        return findFirstSeatOffIndex(sortedNumbers, 0, sortedNumbers.length);
    }

    private int findFirstSeatOffIndex(int[] sortedNumbers, int low, int high){
        int midpoint = (int)Math.floor(getMidpoint(low, high));

        if(midpoint + 1 == high){
            return midpoint;
        } else if(sortedNumbers[midpoint] != midpoint + sortedNumbers[0]){
            return findFirstSeatOffIndex(sortedNumbers, low, midpoint);
        } else {
            return findFirstSeatOffIndex(sortedNumbers, midpoint, high);
        }
    }
}
