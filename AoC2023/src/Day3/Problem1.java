package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Character.isDigit;
import java.util.ArrayList;

public class Problem1 {
    public static void main(String[] args) {
        File f = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day3/input.txt");
        String currLine;
        int row_index = -1;
        ArrayList<Content> contents = new ArrayList<Content>();
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
                                contents.add(num);
                                part_num = 0;
                            }

                        } else {
                            is_num = 0;
                            Content symb = new Content("char",0 ,row_index, i, i);
                            contents.add(symb);

                        }
                    } else is_num = 0;
                }
            }
            // TODO implementare controllo numeri vicino simboli
        } catch (FileNotFoundException e) {
            System.out.println("No file -> " + e);
        }
    }
}
