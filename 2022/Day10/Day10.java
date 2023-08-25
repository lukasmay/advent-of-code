import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day10 {
   public static void main(String[] args) {
        
		//part1();
		part2();
	}

    public static void part1(){
        String line = "";
        ArrayList<String> inputs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day10.txt"));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                inputs.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Loop through the inputs for the running stuff
        boolean moreInput = true;
        int cycle = 0;
        int inputIndex = 0;
        int inputDuration = 1;
        int strength = 0;
        int registry = 1;
        int totalStrength = 0;
        int multiplicity = 0;
        boolean added = true;

        while (moreInput){
            cycle++;
            inputDuration--;
           
            if (inputDuration == 0){
                if (!added){
                    registry = registry + strength;
                    added = true;
                }
                if (inputs.get(inputIndex).substring(0, 1).equals("a")){
                    inputDuration = 2;
                    added = false;
                    strength = Integer.valueOf(inputs.get(inputIndex).substring(5));
                    //System.out.println(" "+cycle);
                } else {
                    inputDuration = 1;
                }
                inputIndex++;
                if (inputIndex == inputs.size()){
                    moreInput = false;
                }
                
            }
            if (((cycle-20)%40) == 0){
                totalStrength = totalStrength + registry * (20 + (40 * multiplicity));
                //System.out.print(registry);
                //System.out.println(" "+totalStrength);
                multiplicity++;
                
            }
            
            
        }
        System.out.println(totalStrength);
    }

    public static void part2(){
        String line = "";
        ArrayList<String> inputs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day10.txt"));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                inputs.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Loop through the inputs for the running stuff
        boolean moreInput = true;
        int cycle = 0;
        int inputIndex = 0;
        int inputDuration = 1;
        int strength = 0;
        int registry = 1;
        int totalStrength = 0;
        int multiplicity = 0;
        boolean added = true;

        while (moreInput){
            cycle++;
            inputDuration--;
           
            if (inputDuration == 0){
                if (!added){
                    registry = registry + strength;
                    added = true;
                }
                if (inputs.get(inputIndex).substring(0, 1).equals("a")){
                    inputDuration = 2;
                    added = false;
                    strength = Integer.valueOf(inputs.get(inputIndex).substring(5));
                    //System.out.println(" "+cycle);
                } else {
                    inputDuration = 1;
                }
                inputIndex++;
                if (inputIndex == inputs.size()){
                    moreInput = false;
                }
                
            }
            if (((cycle-20)-40) == 0){
                totalStrength = totalStrength + registry * (20 + (40 * multiplicity));
                //System.out.print(registry);
                //System.out.println(" "+totalStrength);
                multiplicity++;
                
            } else if (((cycle-20)-80) == 0){
                
            } else if (((cycle-20)-120) == 0){

            } else if (((cycle-20)-160) == 0){

            } else if (((cycle-20)-200) == 0){

            } else if (((cycle-20)-240) == 0){

            }
            
            
        }
        System.out.println(totalStrength);
    }
    
}
