package Day3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class Solver {
    private static final File f = new File("src/Day3/data.txt");
    private Point step;

    public void setStep(Point step){
        this.step = step;
    }

    /**
     * Loads the lines of the {@link File} <code>f</code> and returns it as a stream of {@link String}s.
     * @return the lines of <code>f</code>
     */
    private Stream<String> loadFile(){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(f));
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

        return reader.lines();
    }

    public long solve(){
        // grid[y][x], where (0, 0) is top left corner
        boolean[][] trees = this.loadFile()
                // Mutate into grid of characters
                .map(String::toCharArray)
                // Make new grid of booleans where true marks a tree present
                .map(chars -> {
                    boolean[] treeRow = new boolean[chars.length];
                    for(int i = 0; i < chars.length; i++){
                        treeRow[i] = chars[i] == '#';
                    }
                    return treeRow;
                })
                .toArray(boolean[][]::new);

        int x = 0;
        int y = 0;

        long treesEncountered = 0;

        while(y < trees.length){
            if(trees[y][x]){
                treesEncountered++;
            }
            x = (x + this.step.x) % trees[0].length;
            y += this.step.y;
        }

        return treesEncountered;
    }
}
