package Day3.Puzzle1;
import Day3.Solver;

import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args){
        Solver solver = new Solver(new File("src/main/java/Day3/data.txt"));

        solver.setStep(new Point(3, 1));

        System.out.println(solver.solve());
    }
}
