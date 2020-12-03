package Day3.Puzzle1;

import Day3.GenericSolution;

import java.awt.*;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        GenericSolution solution = new Solution();

        solution.setStep(new Point(3, 1));

        System.out.println(solution.solve());
    }
}
