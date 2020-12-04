package Day3.Puzzle2;

import Day3.Solver;

import java.awt.Point;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Stream<Point> steps = Stream.of(
                new Point(1, 1),
                new Point(3, 1),
                new Point(5, 1),
                new Point(7, 1),
                new Point(1, 2)
        );

        Solver solver = new Solver();

        long answer = steps
                // Run solver on each Point in stream
                .mapToLong(point -> {
                    solver.setStep(point);
                    return solver.solve();
                })
                // Fold multiply
                .reduce(1, (x, y) -> x * y);

        System.out.println(answer);
    }
}
