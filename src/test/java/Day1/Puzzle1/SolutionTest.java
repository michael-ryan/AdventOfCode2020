package Day1.Puzzle1;

import static org.junit.jupiter.api.Assertions.*;

import Day1.GenericTest;
import org.junit.jupiter.api.*;

class SolutionTest extends GenericTest {
    @BeforeEach
    void setUp(){
        super.beforeEach();
        this.solution = new Solution();
    }
    @Test
    void solve(){
        long answer = this.solution.solve(this.data, 2020);

        assertEquals(514579, answer);
    }
}