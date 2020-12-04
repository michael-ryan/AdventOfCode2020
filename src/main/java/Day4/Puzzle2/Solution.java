package Day4.Puzzle2;

import Day4.GenericSolution;
import Day4.Passport;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution extends GenericSolution {
    private static final Map<Passport.Field, String> FIELD_REGEXES = Stream.of(new Object[][] {
            { Passport.Field.BIRTH_YEAR, "19[2-9][0-9]|200[0-2]" },
            { Passport.Field.ISSUE_YEAR, "20(1[0-9]|20)" },
            { Passport.Field.EXPIRATION_YEAR, "20(2[0-9]|30)" },
            { Passport.Field.HEIGHT, "1([5678][0-9]|9[0-3])cm|(59|6[0-9]|7[0-6])in" },
            { Passport.Field.HAIR_COLOUR, "#[0-9a-f]{6}" },
            { Passport.Field.EYE_COLOUR, "b(lu|rn)|gr(n|y)|amb|hzl|oth" },
            { Passport.Field.PASSPORT_ID, "[0-9]{9}" },
            { Passport.Field.COUNTRY_ID, ".*" },
    }).collect(Collectors.toMap(data -> (Passport.Field) data[0], data -> (String) data[1]));


    public static void main(String[] args){
        GenericSolution solution = new Solution();

        long answer = solution.solve();

        System.out.println(answer);
    }

    @Override
    public boolean passportIsValid(Passport passport){
        boolean valid;

        if(passport.getFieldsPresent().size() == 8){
            valid = true;
        } else if(passport.getFieldsPresent().size() == 7){
            valid = !passport.getFieldsPresent().contains(Passport.Field.COUNTRY_ID);
        } else {
            valid = false;
        }

        for(Map.Entry<Passport.Field, String> data : passport.getFieldData().entrySet()){
            Passport.Field field = data.getKey();
            String value = data.getValue();

            valid = valid && value.matches(FIELD_REGEXES.get(field));
        }

        return valid;
    }
}
