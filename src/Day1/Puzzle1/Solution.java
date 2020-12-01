package Day1.Puzzle1;

import Day1.GenericSolution;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new Solution();

        solution.solve(numbers);
    }

    @Override
    public void solve(int[] numbers){
        int a = 0;
        int b = 0;

        int correctA = 0;
        int correctB = 0;

        for(int i = 0; i < numbers.length - 1; i++){
            a = numbers[i];
            for(int j = i + 1; j < numbers.length; j++){
                b = numbers[j];
                if(a + b == 2020){
                    correctA = a;
                    correctB = b;
                }
            }
        }

        System.out.println(correctA * correctB);
    }
}
