package Day1.Puzzle2;

import Day1.GenericSolution;

import java.util.Arrays;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new Solution();

        long answer = solution.solve(numbers, TARGET);
        System.out.println(answer);
    }

    @Override
    public long solve(int[] numbers, int target){
        Arrays.sort(numbers);

        int correctI = 0;
        int smallPointer = 0;
        int bigPointer = 0;

        for(int i = 0; i < numbers.length; i++){
            int currentTarget = target - numbers[i];

            smallPointer = 0;
            bigPointer = numbers.length - 1;

            boolean done = false;

            while(!done){
                if(smallPointer == i){
                    smallPointer++;
                    continue;
                } else if(bigPointer == i){
                    bigPointer--;
                    continue;
                }

                if(smallPointer >= bigPointer){
                    break;
                }
                int total = numbers[smallPointer] + numbers[bigPointer];
                if(total > currentTarget){
                    bigPointer--;
                } else if(total < currentTarget){
                    smallPointer++;
                } else {
                    done = true;
                    correctI = i;
                }
            }
            if(done){
                break;
            } else if(i == numbers.length - 1){
                throw new RuntimeException("No answer here");
            }
        }

        return numbers[correctI] * numbers[smallPointer] * numbers[bigPointer];
    }
}
