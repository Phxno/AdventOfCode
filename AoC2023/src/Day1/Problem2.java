package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Character.isDigit;
import java.util.HashMap;


public class Problem2 {
    public static void main(String[] args) {
        // try ( Reader reader = new BufferedReader(new FileReader("input1.txt"));
        //char currchr;
        HashMap<String, Integer> nums = new HashMap<String, Integer>();
        nums.put("one",1);
        nums.put("two",2);
        nums.put("three",3);
        nums.put("four",4);
        nums.put("five",5);
        nums.put("six",6);
        nums.put("seven",7);
        nums.put("eight",8);
        nums.put("nine",9);

        //for (String val: nums.keySet()) System.out.println(val);

        int sum = 0;
        File file = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day1/input1.txt");
        try(Scanner scanner = new Scanner(file)){
            int a = -1;
            int b = -1;
            int k = 1;
            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();
                //if (currLine.contains(nums.get(2))) System.out.println("Yes 2 is here " + currLine.indexOf(nums.get(2)));
                for (int i = 0; i < currLine.length(); i++) {
                    char chr = currLine.charAt(i);
                    //System.out.println(chr);
                    if (isDigit(chr)) {
                        b = i;
                        if (a == -1) a = i;
                    }
                }
                for (String val : nums.keySet()) {
                    if (currLine.contains(val)) {
                        int ind_l = currLine.indexOf(val);
                        int ind_r = currLine.lastIndexOf(val);
                        if (ind_l < a || a == -1) a = ind_l;
                        if (ind_r > b) b = ind_r;
                    }
                }
                //System.out.println("a " + a + " b " + b);
                if (a != -1 && b != -1) {
                    if (isDigit(currLine.charAt(a))) a = currLine.charAt(a) - 0x30;
                    else {
                        for (String val : nums.keySet()) {
                            if (currLine.substring(a, a + val.length()).compareTo(val) == 0) {
                                a = nums.get(val);
                                break;
                            }
                        }
                    }
                    if (isDigit(currLine.charAt(b))) b = currLine.charAt(b) - 0x30;
                    else {
                        for (String val : nums.keySet()) {
                            if ((b + val.length()) <= currLine.length()) {
                                if (currLine.substring(b, b + val.length()).compareTo(val) == 0) {
                                    //System.out.println("b->"+b+" b+l->"+(b+val.length()+ " cl->"+ currLine.length() ));
                                    b = nums.get(val);
                                    break;
                                }
                            }
                        }
                    }
                    //System.out.println("line " + k + "->" + " a " + a + " b " + b + " - " + currLine);
                    //k++;

                    sum += a * 10 + b;

                }
                a = -1;
                b = -1;
            }
        } catch (FileNotFoundException e){
            System.out.println("Problem here -> " + e);
        }
        System.out.println("->" + sum);
    }
}


