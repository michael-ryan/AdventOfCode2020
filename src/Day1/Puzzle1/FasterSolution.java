package Day1.Puzzle1;

import Day1.GenericSolution;

import java.util.Arrays;

public class FasterSolution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new FasterSolution();

        solution.solve(numbers);
    }

    @Override
    public void solve(int[] numbers){
        Arrays.sort(numbers);

        int smallPointer = 0;
        int bigPointer = numbers.length - 1;

        boolean done = false;

        while(!done){
            int total = numbers[smallPointer] + numbers[bigPointer];
            if(total > 2020){
                bigPointer--;
            } else if(total < 2020){
                smallPointer++;
            } else {
                done = true;
                System.out.println(numbers[smallPointer] * numbers[bigPointer]);
            }
        }
    }
}
