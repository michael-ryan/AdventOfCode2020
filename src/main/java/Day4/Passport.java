package Day4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Passport {

    public enum Field {
        BIRTH_YEAR,
        ISSUE_YEAR,
        EXPIRATION_YEAR,
        HEIGHT,
        HAIR_COLOUR,
        EYE_COLOUR,
        PASSPORT_ID,
        COUNTRY_ID
    }

    private static final Map<String, Field> ENTRIES = Stream.of(new Object[][] {
            { "byr", Field.BIRTH_YEAR },
            { "iyr", Field.ISSUE_YEAR },
            { "eyr", Field.EXPIRATION_YEAR },
            { "hgt", Field.HEIGHT },
            { "hcl", Field.HAIR_COLOUR },
            { "ecl", Field.EYE_COLOUR },
            { "pid", Field.PASSPORT_ID },
            { "cid", Field.COUNTRY_ID },
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Field)data[1]));

    private final Map<Field, String> fieldData = new HashMap<>();

    public void addLine(String line){
        if(line.isEmpty()){
            throw new RuntimeException("Empty line given to Passport.addLine");
        }

        for(String entry : line.split(" ")){
            Field key = ENTRIES.get(entry.split(":")[0]);
            String value = entry.split(":")[1];
            fieldData.put(key, value);
        }
    }

    public Map<Field, String> getFieldData(){
        return fieldData;
    }
}
