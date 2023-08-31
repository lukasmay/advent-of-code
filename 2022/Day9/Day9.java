import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.HashMap;
/*
 * What I need to store:
 *     
 * 
 * The problem is that the array has the same values for where the thing moves
 * This means that the logic not working
 */

public class Day9 {
    public static void main(String[] args) {
        
		//part1();
		part2();
	}

    public static void part1(){
        String line = "";
        Integer[] currentHeadPosition = {0, 0};//x y grid
        Integer[] currentTailPosition = {0, 0};
        Integer[] lastHeadPosition = {0, 0};
        String direction = "";
        HashMap<String, Integer> tailHasBeen = new HashMap<>();
        

        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day9.txt"));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                direction = line.substring(0, 1);
                for (int i = 0; i < Integer.valueOf(line.substring(2)); i++){
                    lastHeadPosition[0] = currentHeadPosition[0];
                    lastHeadPosition[1] = currentHeadPosition[1];
                    //Moving the Head
                    if (direction.equals("R")){
                        //lastHeadPosition[0] = currentHeadPosition[0];
                        currentHeadPosition[0] = currentHeadPosition[0] + 1;
                    } else if (direction.equals("L")){
                        //lastHeadPosition[0] = currentHeadPosition[0];
                        currentHeadPosition[0] = currentHeadPosition[0] - 1;
                    } else if (direction.equals("U")){
                        //lastHeadPosition[1] = currentHeadPosition[1];
                        currentHeadPosition[1] = currentHeadPosition[1] + 1;
                    } else if (direction.equals("D")){
                        //lastHeadPosition[1] = currentHeadPosition[1];
                        currentHeadPosition[1] = currentHeadPosition[1] - 1;
                    }

                    //Checking and moving tail
                    if (toFar(currentHeadPosition, currentTailPosition)){
                        currentTailPosition[0] = lastHeadPosition[0];
                        currentTailPosition[1] = lastHeadPosition[1];
                       
                        //System.out.println(" Moved ");
                        
                    }
                    //System.out.print(" Tail " +currentTailPosition[0] + " " + currentTailPosition[1]);
                    //System.out.print(" Head " +currentHeadPosition[0] + " " + currentHeadPosition[1]);
                    //System.out.println(" LastH " +lastHeadPosition[0] + " " + lastHeadPosition[1]);
                    String holder = Integer.toString(currentTailPosition[0]) + " " +Integer.toString(currentTailPosition[1]);
                    tailHasBeen.put(holder, 1);
                    
                }
            }

            System.out.println(tailHasBeen.size());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }    

    public static boolean toFar(Integer[] headposition, Integer[] tailPosition){
        boolean toFar = false;
        //System.out.print(" X "+Math.abs(tailPosition[0] - headposition[0]));
        //System.out.print(" Y "+Math.abs(tailPosition[1] - headposition[1]));
        

        if(Math.abs(tailPosition[0] - headposition[0]) >= 2){
            toFar = true;
        } else if (Math.abs(tailPosition[1] - headposition[1]) >= 2){
            toFar = true;
        }
        //System.out.print(" Check "+ toFar);
        return toFar;
    }

    public static void part2(){
        String line = "";
        Integer[][] position = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}};
        Integer[] lastPosition = {0, 0};
        String direction = "";
        boolean move = true;
        HashMap<String, Integer> tailHasBeen = new HashMap<>();
        

        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day9.txt"));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                direction = line.substring(0, 1);
                for (int i = 0; i < Integer.valueOf(line.substring(2)); i++){

                    //Updates lastPostion to be that of the old head
                    lastPosition[0] = position[0][0]; lastPosition[1] = position[0][1];

                    //Moves the head
                    if (direction.equals("R")){
                        position[0][0] = position[0][0] + 1;
                    } else if (direction.equals("L")){
                        position[0][0] = position[0][0] - 1;
                    } else if (direction.equals("U")){
                        position[0][1] = position[0][1] + 1;
                    } else if (direction.equals("D")){
                        position[0][1] = position[0][1] - 1;
                    }

                    //Loops through all of the following ropes
                    for (int a = 0; a < 9; a++){
                        if (a > 0){
                            lastPosition[0] = position[a][0]; 
                            lastPosition[1] = position[a][1];
                        }
                        //This needs to be position[a-1] to work Sort off. Work through this loop to find out what is wrong
                        if (toFar(position[a], position[(a+1)])){
                            position[a+1][0] = lastPosition[0]; position[a+1][1] = lastPosition[1];
                            //System.out.println(" Moved ");   
                        } else {
                            move = false;
                            break;
                        }
                        
                    }
                String holder = Integer.toString(position[9][0]) + " " +Integer.toString(position[9][1]);
                tailHasBeen.put(holder, 1);
                
                }
            }
            //tailHasBeen.forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println(tailHasBeen.size());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
