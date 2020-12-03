package Day3.Puzzle2;

import Day3.GenericSolution;

import java.awt.Point;
import java.util.stream.Stream;

public class Solution extends GenericSolution {
    public static void main(String[] args){
        Stream<Point> steps = Stream.of(new Point(1, 1), new Point(3, 1), new Point(5, 1), new Point(7, 1), new Point(1, 2));

        GenericSolution solution = new Solution();

        long answer = steps
                .mapToLong(point -> {
                    solution.setStep(point);
                    return solution.solve();
                })
                .reduce(1, (x, y) -> x * y);

        System.out.println(answer);


    }
}
