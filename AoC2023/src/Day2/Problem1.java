package Day2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Character.isDigit;

public class Problem1 {
    public static void main(String[] args){
        final int R = 12;
        final int G = 13;
        final int B = 14;
        int sum_of_ids = 0;
        int g_counter = 0;

        File file = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day2/input.txt");
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                g_counter++;
                int flag = 1;
                String currLine = scanner.nextLine();
                int lokat = 0;
                while ( (lokat= currLine.indexOf("red", lokat +1 )) != -1){
                    if (isDigit(currLine.charAt(lokat - 2))) {
                        if (!isDigit(currLine.charAt(lokat - 3))) {
                            if ((currLine.charAt(lokat - 2) - 0x30) > R ) {
                                flag = 0;
                                break;
                            }
                        } else {
                            if ( (currLine.charAt(lokat-3)-0x30)*10 + (currLine.charAt(lokat-2)-0x30) > R){
                                flag = 0;
                                break;
                            }
                        }
                    }
                }
                lokat = 0;
                while ( (lokat= currLine.indexOf("blue", lokat +1)) != -1){
                    if (isDigit(currLine.charAt(lokat - 2))) {
                        if (!isDigit(currLine.charAt(lokat - 3))) {
                            if ((currLine.charAt(lokat - 2) - 0x30) > B ) {
                                flag = 0;
                                break;
                            }
                        } else {
                            if ( (currLine.charAt(lokat-3)-0x30)*10 + (currLine.charAt(lokat-2)-0x30) > B){
                                flag = 0;
                                break;
                            }
                        }
                    }
                }
                lokat = 0;
                while ( (lokat= currLine.indexOf("green", lokat +1)) != -1){
                    if (isDigit(currLine.charAt(lokat - 2))) {
                        if (!isDigit(currLine.charAt(lokat - 3))) {
                            if ((currLine.charAt(lokat - 2) - 0x30) > G ) {
                                flag = 0;
                                break;
                            }
                        } else {
                            if ( (currLine.charAt(lokat-3)-0x30)*10 + (currLine.charAt(lokat-2)-0x30) > G){
                                flag = 0;
                                break;
                            }
                        }
                    }
                }
                if (flag == 1) sum_of_ids += g_counter;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problema: " + e);
        };
        System.out.println("-> " +  sum_of_ids);
    }
}
