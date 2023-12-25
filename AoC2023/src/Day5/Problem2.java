package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import static java.lang.Character.isDigit;

// Da ottimizzare, decisamente

public class Problem2 {
    public static void main(String[] args){
        File f = new File("/home/brt-phono/git_reps/AdventOfCode/AoC2023/src/Day5/input.txt");
        double result = -1;
        try( Scanner scan = new Scanner(f) ){
            ArrayList<Range> soil = new ArrayList<Range>();
            ArrayList<Range> fertilizer = new ArrayList<Range>();
            ArrayList<Range> water = new ArrayList<Range>();
            ArrayList<Range> light = new ArrayList<Range>();
            ArrayList<Range> temperature = new ArrayList<Range>();
            ArrayList<Range> humidity = new ArrayList<Range>();
            ArrayList<Range> location = new ArrayList<Range>();
            ArrayList<Range> seeds = new ArrayList<Range>();
            String next = scan.nextLine();
            double curr_number = 0;
            int ncounter = 0;
            double temp = 0;
            for (int i = next.indexOf(':'); i < next.length(); i++){
                if ( isDigit(next.charAt(i)) ){
                    curr_number = curr_number*10 + (next.charAt(i) - 0x30);
                    if ( i == next.length()-1 || next.charAt(i + 1) == ' '){
                        if (ncounter == 0){
                            ncounter ++;
                            temp = curr_number;
                        } else {
                            ncounter--;
                            seeds.add(new Range(temp + curr_number, temp , curr_number));
                        }
                        curr_number = 0;
                    }
                }
            }
            int counter = 0;
            while (scan.hasNextLine()){
                String currLine = scan.nextLine();
                ArrayList<Double> range_temp = new ArrayList<Double>();
                if (currLine.contains("map")) counter++;
                else if (currLine.length() > 1){
                    for (int i = 0; i < currLine.length(); i++){
                        if ( isDigit(currLine.charAt(i)) ){
                            curr_number = curr_number*10 + (currLine.charAt(i) - 0x30);
                            if ( i == currLine.length()-1 || currLine.charAt(i + 1) == ' '){
                                range_temp.add(curr_number);
                                curr_number = 0;
                            }
                        }
                    }
                    Range range = new Range(range_temp.get(0), range_temp.get(1),range_temp.get(2));
                    switch (counter){
                        case 1:
                            soil.add(range);
                            break;
                        case 2:
                            fertilizer.add(range);
                            break;
                        case 3:
                            water.add(range);
                            break;
                        case 4:
                            light.add(range);
                            break;
                        case 5:
                            temperature.add(range);
                            break;
                        case 6:
                            humidity.add(range);
                            break;
                        case 7:
                            location.add(range);
                            break;
                    }
                    range_temp.clear();
                }
            }
            for (Range seed_range: seeds){
                for (double counting_seed = seed_range.getSource(); counting_seed <= seed_range.getDestination(); counting_seed++){
                    double seed = counting_seed;
                    for(Range r: soil){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource()); // seed - r.getRange()
                            break;
                        }
                    }
                    for(Range r: fertilizer){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource());
                            break;
                        }
                    }
                    for(Range r: water){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource());
                            break;
                        }
                    }
                    for(Range r: light){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource());
                            break;
                        }
                    }
                    for(Range r: temperature){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource());
                            break;
                        }
                    }
                    for(Range r: humidity){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource());
                            break;
                        }
                    }
                    for(Range r: location){
                        if ((seed >= r.getSource()) && (seed <= r.getRangeSrc())){
                            seed = r.getDestination() + (seed - r.getSource());
                            break;
                        }
                    }
                    if (result == -1) result = seed;
                    else if (seed <= result) result = seed;
                }
            }
            System.out.println("-> " + result);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }
    }
}
