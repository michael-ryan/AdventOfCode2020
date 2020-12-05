package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileLoader {
    private FileLoader(){}

    /**
     * Loads the lines of the supplied file and returns it as a {@link Stream} of {@link String}s.
     * @param f the file to read from
     * @return a stream containing the lines of the file
     */
    public static Stream<String> loadFile(File f){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(f));
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

        return reader.lines();
    }

    public static IntStream loadAsIntegers(File f){
        return loadFile(f).mapToInt(Integer::parseInt);
    }
}
