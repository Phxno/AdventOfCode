package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.Scanner;
import static java.lang.Character.isDigit;
import java.util.ArrayList;

public class Problem2 {
    public static void main(String[] args) {
        File f = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day3/input.txt");
        String currLine;
        int row_index = -1;
        int sum = 0;
        ArrayList<Content> chars = new ArrayList<Content>();
        ArrayList<Content> nums = new ArrayList<Content>();
        try (Scanner scan = new Scanner(f)) {
            int is_num;
            int part_num;
            int first_index = 0;
            while (scan.hasNextLine()){
                is_num = 0;
                part_num = 0;
                row_index++;
                currLine = scan.nextLine();
                for (int i = 0; i< currLine.length(); i++){
                    //System.out.println("char: " + currLine.charAt(i) + " i: " + i);
                    if ( currLine.charAt(i) != '.' ){
                        if(isDigit(currLine.charAt(i))) {
                            if (is_num == 1){
                                part_num = part_num * 10;
                            } else first_index = i;
                            part_num += (currLine.charAt(i) - 0x30);
                            is_num = 1;
                            if (i == currLine.length()-1 || !isDigit(currLine.charAt(i + 1))){
                                Content num = new Content("num", part_num, row_index, first_index, i);
                                nums.add(num);
                                part_num = 0;
                            }

                        } else {
                            is_num = 0;
                            Content symb = new Content("char",0 ,row_index, i, i);
                            chars.add(symb);

                        }
                    } else is_num = 0;
                }
            }
            int n_nums;
            int num_1;
            int num_2;
            for (Content sym: chars){
                n_nums = 0;
                num_1 = 0;
                num_2 = 0;
                for (Content num: nums){
                    if (num.get_Row() > sym.get_Row() + 1) break;
                    if (num.get_Row() >= sym.get_Row() - 1){
                        int ind = num.getStart_index();
                        if (Math.max(sym.getStart_index(), ind) - Math.min(sym.getStart_index(), ind) <= 1 ||
                                Math.max(sym.getLast_index(), num.getLast_index()) - Math.min(sym.getLast_index(), num.getLast_index()) <= 1){
                            if (num_1 == 0) num_1 = num.getValue();
                            else num_2 = num.getValue();
                            n_nums++;
                        }
                    }
                }
                if (n_nums == 2) sum += num_1*num_2;
            }
            System.out.println("-> " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("No file -> " + e);
        }
    }
}
