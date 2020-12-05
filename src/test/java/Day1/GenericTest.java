package Day1;

import Common.FileLoader;

import java.io.File;

public class GenericTest {
    protected GenericSolution solution;
    protected int[] data;

    public void beforeEach(){
        this.data = FileLoader.loadAsIntegers(new File("src/test/java/Day1/data.txt")).toArray();
    }
}
