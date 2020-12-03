package Day3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public abstract class GenericSolution {
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
        String[] map = this.loadFile().toArray(String[]::new);

        // grid[y][x], where (0, 0) is top left corner
        char[][] grid = new char[map.length][];

        for(int i = 0; i < map.length; i++){
            grid[i] = map[i].toCharArray();
        }

        int x = 0;
        int y = 0;

        long treesEncountered = 0;

        while(y < grid.length){
            if(treeAtPosition(grid, x, y)){
                treesEncountered++;
            }
            x = (x + this.step.x) % grid[0].length;
            y += this.step.y;
        }

        return treesEncountered;
    }

    private static boolean treeAtPosition(char[][] grid, int x, int y){
        return grid[y][x] == '#';
    }
}
