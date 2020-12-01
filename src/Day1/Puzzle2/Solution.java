package Day1.Puzzle2;

import Day1.GenericSolution;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        int[] numbers = parseProblem();

        Solution solution = new Solution();

        solution.solve(numbers);
    }

    @Override
    protected void solve(int[] numbers){
        int a = 0;
        int b = 0;
        int c = 0;

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
        System.out.println(correctA * correctB * correctC);
    }
}
