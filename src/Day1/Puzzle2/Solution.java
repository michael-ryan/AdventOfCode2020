package Day1.Puzzle2;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args){
        ArrayList<Integer> numbers = parseFile(new File("src/Day1/Problem.txt"));

        solve(numbers);
    }

    private static ArrayList<Integer> parseFile(File f){
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(f));
        } catch(FileNotFoundException e){
            System.out.println("File " + f.toString() + " not found.");
            System.exit(1);
            return null;
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        String s;
        while (true){
            try {
                if((s = reader.readLine()) == null) break;
            } catch(IOException e) {
                e.printStackTrace();
                System.exit(2);
                return null;
            }
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static void solve(ArrayList<Integer> numbers){
        int a = 0;
        int b = 0;
        int c = 0;

        int correctA = 0;
        int correctB = 0;
        int correctC = 0;

        for(int i = 0; i < numbers.size() - 1; i++){
            a = numbers.get(i);
            for(int j = i + 1; j < numbers.size(); j++){
                b = numbers.get(j);
                for(int k = j + 1; k < numbers.size(); k++){
                    c = numbers.get(k);
                    if(a + b + c == 2020){
                        correctA = a;
                        correctB = b;
                        correctC = c;
                    }
                }
            }
        }
        System.out.println(correctA * correctB * correctC);
    }
}
