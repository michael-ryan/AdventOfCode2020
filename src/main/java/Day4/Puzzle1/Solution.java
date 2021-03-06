package Day4.Puzzle1;

import Day4.GenericSolution;
import Day4.Passport;

public class Solution extends GenericSolution {

    public static void main(String[] args){
        GenericSolution solution = new Solution();

        long answer = solution.solve();

        System.out.println(answer);
    }

    @Override
    public boolean passportIsValid(Passport passport){
        boolean valid;

        if(passport.getFieldData().size() == 8){
            valid = true;
        } else if(passport.getFieldData().size() == 7){
            valid = !passport.getFieldData().containsKey(Passport.Field.COUNTRY_ID);
        } else {
            valid = false;
        }

        return valid;
    }
}
