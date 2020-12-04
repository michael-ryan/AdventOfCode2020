package Day1.Puzzle1;

import Day1.GenericSolution;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new Solution();

        System.out.println(solution.solve(numbers, TARGET));
    }

    @Override
    public long solve(int[] numbers, int target){
        int a;
        int b;

        int correctA = 0;
        int correctB = 0;

        for(int i = 0; i < numbers.length - 1; i++){
            a = numbers[i];
            for(int j = i + 1; j < numbers.length; j++){
                b = numbers[j];
                if(a + b == target){
                    correctA = a;
                    correctB = b;
                }
            }
        }

        return correctA * correctB;
    }
}
