package Day3;

import Common.FileLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolverTest {
    protected Solver solver;

    @BeforeEach
    void setUp(){
        this.solver = new Solver(new File("src/test/java/Day3/data.txt"));
    }

    @ParameterizedTest
    @MethodSource("provideGradientsAndAnswers")
    void solve(Map.Entry<Point, Long> entry){
        Point input = entry.getKey();
        long expectedOutput = entry.getValue();

        this.solver.setStep(input);

        long answer = this.solver.solve();

        assertEquals(expectedOutput, answer);
    }

    private static Set<Map.Entry<Point, Long>> provideGradientsAndAnswers() {
        Map<Point, Long> gradientAnswerMap = new HashMap<>();
        gradientAnswerMap.put(new Point(1, 1), 2L);
        gradientAnswerMap.put(new Point(3, 1), 7L);
        gradientAnswerMap.put(new Point(5, 1), 3L);
        gradientAnswerMap.put(new Point(7, 1), 4L);
        gradientAnswerMap.put(new Point(1, 2), 2L);

        return gradientAnswerMap.entrySet();
    }
}
