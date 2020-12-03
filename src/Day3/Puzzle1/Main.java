package Day3.Puzzle1;

import Day3.Solver;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        Solver solver = new Solver();

        solver.setStep(new Point(3, 1));

        System.out.println(solver.solve());
    }
}
