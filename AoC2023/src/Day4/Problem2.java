package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.Math;
import static java.lang.Character.isDigit; 

public class Problem2 {
    public static void main(String[] args){
        File f = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day4/input.txt");
        int result = 0;
        try(Scanner scan = new Scanner(f)){
            int winners;
            int curr_number;
            boolean win = true;
            ArrayList<Integer> winnings = new ArrayList<Integer>();
            ArrayList<Integer> copies = new ArrayList<Integer>();
            
            while ( scan.hasNextLine() ){
                String next = scan.nextLine();
                if (copies.isEmpty()) copies.add(1);
                else copies.addFirst(copies.removeFirst() + 1);
                winners = 0;
                curr_number = 0;
                win = true;
                int i = next.indexOf(':');
                for ( ; i < next.length() ; i++ ){
                    if ( next.charAt(i) ==  '|' ){
                        win = false;
                    }
                    if ( isDigit(next.charAt(i)) ){
                        curr_number = curr_number*10 + (next.charAt(i) - 0x30);

                        if ( i == next.length()-1 || next.charAt(i + 1) == ' '){
                            if (win) winnings.add(curr_number);
                            else if (winnings.contains(curr_number)) winners++;
                            curr_number = 0;
                        }
                    }
                } 
               for (int j = 0; j < winners; j++){
                   int first = copies.getFirst();
                   if (copies.size() <= j+1){
                       copies.add(first);
                   } else {
                       System.out.println("1- " +  copies);
                       copies.add(j+1, copies.remove(j+1) + first);
                       System.out.println("2- " +copies);
                   }
               }
            winnings.clear();
            result += copies.removeFirst();
                
            }
            System.out.println("-> " + result);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
}
