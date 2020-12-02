package Day1.Puzzle1;

import Day1.GenericSolution;

import java.util.Arrays;

public class FasterSolution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new FasterSolution();

        long answer = solution.solve(numbers, TARGET);
        System.out.println(answer);
    }

    @Override
    public long solve(int[] numbers, int target){
        Arrays.sort(numbers);

        int smallPointer = 0;
        int bigPointer = numbers.length - 1;

        boolean done = false;

        while(!done){
            if(smallPointer >= bigPointer){
                throw new RuntimeException("No answer here");
            }

            int total = numbers[smallPointer] + numbers[bigPointer];
            if(total > target){
                bigPointer--;
            } else if(total < target){
                smallPointer++;
            } else {
                done = true;
            }
        }

        return numbers[smallPointer] * numbers[bigPointer];
    }
}
