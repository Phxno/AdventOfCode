package Day2;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.Character.isDigit;

public class Problem2 {
    public static void main(String[] args){
        int sum_of_pow = 0;


        File file = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day2/input.txt");
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                int R = 0;
                int G = 0;
                int B = 0;
                int cR = 0;
                int cG = 0;
                int cB = 0;
                String currLine = scanner.nextLine();
                int lokat = 0;
                while ( (lokat= currLine.indexOf("red", lokat +1 )) != -1){
                    if (isDigit(currLine.charAt(lokat - 2))) {
                        if (!isDigit(currLine.charAt(lokat - 3))) {
                            if ( (cR = (currLine.charAt(lokat - 2) - 0x30)) > R ) R = cR;
                        } else {
                            if ( (cR = (currLine.charAt(lokat-3)-0x30)*10 + (currLine.charAt(lokat-2)-0x30)) > R) R = cR;
                        }
                    }
                }
                lokat = 0;
                while ( (lokat= currLine.indexOf("green", lokat +1 )) != -1){
                    if (isDigit(currLine.charAt(lokat - 2))) {
                        if (!isDigit(currLine.charAt(lokat - 3))) {
                            if ( (cG = (currLine.charAt(lokat - 2) - 0x30)) > G ) G = cG;
                        } else {
                            if ( (cG = (currLine.charAt(lokat-3)-0x30)*10 + (currLine.charAt(lokat-2)-0x30)) > G) G = cG;
                        }
                    }
                }
                lokat = 0;
                while ( (lokat= currLine.indexOf("blue", lokat +1 )) != -1){
                    if (isDigit(currLine.charAt(lokat - 2))) {
                        if (!isDigit(currLine.charAt(lokat - 3))) {
                            if ( (cB = (currLine.charAt(lokat - 2) - 0x30)) > B ) B = cB;
                        } else {
                            if ( (cB = (currLine.charAt(lokat-3)-0x30)*10 + (currLine.charAt(lokat-2)-0x30)) > B) B = cB;
                        }
                    }
                }
                sum_of_pow += R*G*B;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problema: " + e);
        };
        System.out.println("-> " +  sum_of_pow);
    }
}
