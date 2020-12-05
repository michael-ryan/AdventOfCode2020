package Day2;

import Common.FileLoader;

import java.io.File;
import java.util.stream.Stream;

public class GenericTest {
    protected GenericSolution solution;
    protected Stream<String> data;

    public void beforeEach(){
        this.data = FileLoader.loadFile(new File("src/test/java/Day2/data.txt"));
    }
}
