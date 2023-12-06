package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Character.isDigit;


public class Problem1 {
    public static void main(String[] args) {
        // try ( Reader reader = new BufferedReader(new FileReader("input1.txt"));
        //char currchr;
        int sum = 0;
        File file = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day1/input1.txt");
        try(Scanner scanner = new Scanner(file)){
            int a = -1;
            int b = -1;
            while (scanner.hasNextLine()){
                String currLine = scanner.nextLine();
                //if (currLine.contains(nums.get(2))) System.out.println("Yes 2 is here " + currLine.indexOf(nums.get(2)));
                for (int i = 0; i < currLine.length(); i++){
                    char chr = currLine.charAt(i);
                    //System.out.println(chr);
                    if (isDigit(chr)){
                        b = i;
                        if (a == -1) a = i;
                    }
                }
                sum += a*10 + b;
                a = -1;
                b = -1;
            }
        } catch (FileNotFoundException e){
            System.out.println("Problem here -> " + e);
        }
    System.out.println("->" + sum);
    }
}


