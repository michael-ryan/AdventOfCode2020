package Day3;

import Common.FileLoader;

import java.awt.*;
import java.io.File;

public class Solver {
    private final File f;
    private Point step;

    public Solver(File f){
        this.f = f;
    }

    public void setStep(Point step){
        this.step = step;
    }

    public long solve(){
        // grid[y][x], where (0, 0) is top left corner
        boolean[][] trees = FileLoader.loadFile(f)
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
