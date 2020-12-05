package Day5.Puzzle2;

import Day5.GenericSolution;

import java.util.Arrays;

// Finds the missing element in a list of otherwise contiguous integers from a to b by sorting, then using
// a binary search and comparing the current item's value to (its index + lowest number in list)

// Not as quick as just summing all numbers from a to b then subtracting the list's sum, but this was more
// fun to code.

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
