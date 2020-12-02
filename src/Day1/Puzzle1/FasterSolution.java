package Day1.Puzzle1;

import Day1.GenericSolution;

import java.util.Arrays;

public class FasterSolution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new FasterSolution();

        Pair answer = solution.solve(numbers, 2020);
        System.out.println(answer.getFirst() * answer.getSecond());
    }

    @Override
    public Pair solve(int[] numbers, int target){
        Arrays.sort(numbers);

        int smallPointer = 0;
        int bigPointer = numbers.length - 1;

        boolean done = false;

        while(!done){
            if(smallPointer >= bigPointer){
                return null;
            }

            int total = numbers[smallPointer] + numbers[bigPointer];
            if(total > 2020){
                bigPointer--;
            } else if(total < 2020){
                smallPointer++;
            } else {
                done = true;
            }
        }

        return new Pair(numbers[smallPointer], numbers[bigPointer]);
    }
}
