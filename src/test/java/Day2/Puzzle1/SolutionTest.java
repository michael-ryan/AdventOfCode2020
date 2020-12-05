package Day2.Puzzle1;

import Day2.GenericTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest extends GenericTest {
    @BeforeEach
    void setUp(){
        super.beforeEach();
        this.solution = new Solution();
    }

    @Test
    void solve(){
        long answer = this.solution.solve(this.data);

        assertEquals(2, answer);
    }
}