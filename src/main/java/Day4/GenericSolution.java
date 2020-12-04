package Day4;

import Common.FileLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericSolution {

    private static final File f = new File("src/main/java/Day4/data.txt");

    public long solve(){
        String[] lines = FileLoader.loadFile(f).toArray(String[]::new);

        List<Passport> passports = new ArrayList<>();

        Passport passport = new Passport();
        for(String s : lines){
            if(s.isEmpty()){
                passports.add(passport);
                passport = new Passport();
            } else {
                passport.addLine(s);
            }
        }

        passports.add(passport);

        return passports
                .stream()
                .filter(this::passportIsValid)
                .count();
    }

    public abstract boolean passportIsValid(Passport passport);
}
