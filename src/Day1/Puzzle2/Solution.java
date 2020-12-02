package Day1.Puzzle2;

import Day1.GenericSolution;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        GenericSolution solution = new Solution();

        System.out.println(solution.solve(numbers));
    }

    @Override
    public long solve(int[] numbers){
        int a;
        int b;
        int c;

        int correctA = 0;
        int correctB = 0;
        int correctC = 0;

        for(int i = 0; i < numbers.length - 1; i++){
            a = numbers[i];
            for(int j = i + 1; j < numbers.length; j++){
                b = numbers[j];
                for(int k = j + 1; k < numbers.length; k++){
                    c = numbers[k];
                    if(a + b + c == 2020){
                        correctA = a;
                        correctB = b;
                        correctC = c;
                    }
                }
            }
        }
        return correctA * correctB * correctC;
    }
}
