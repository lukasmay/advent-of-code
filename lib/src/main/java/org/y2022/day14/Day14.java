package org.y2022.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/* I just need to transition to an array[][] for storing the rocks
 *      This will allow for me to loop through the loop
 *      The array will need to be from the max to the minimum
 */
public class Day14{

    public static void main(String[] args) {

    		part1();
    		//part2();
    	}

        public static void part1(){
            String line = "";
            String[] holder1 = {"", ""};
            HashMap<String, String> map = new HashMap<>();
            int max = 0;
            int min = 0;
            String[][] cave = new String[50][30];
            
            try {
                Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day14.txt"));
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    String[] rockLinePostition = line.split(" ");
                    for (int i = 0; i < rockLinePostition.length -1; i++){
                        holder1 = rockLinePostition[i].split(",");
                        
                        int upDownCheck = (Integer.valueOf(holder1[0])) - Math.abs(Integer.valueOf(rockLinePostition[i+1].substring(0, rockLinePostition[i+1].indexOf(","))));
                        int leftRightCheck = (Math.abs(Integer.valueOf(holder1[1])) - Math.abs(Integer.valueOf(rockLinePostition[i+1].substring(rockLinePostition[i+1].indexOf(",")+1))));
                        
                        //System.out.print(Math.abs(Integer.valueOf(holder1[1]))+ " - ");
                        //System.out.print(Math.abs(Integer.valueOf(rockLinePostition[i+1].substring(rockLinePostition[i+1].indexOf(",")+1))));
                        //System.out.println(" = "+leftRightCheck);
                        if (upDownCheck < 0){
                            for (int a = 0; a < Math.abs(upDownCheck); a++){
                                cave[Integer.valueOf(holder1[0])-a][Integer.valueOf(holder1[1])] = "#";
                            }
                        } else if (upDownCheck > 0){
                            for (int a = 0; a < Math.abs(upDownCheck); a++){
                                cave[Integer.valueOf(holder1[0])+a][Integer.valueOf(holder1[1])] = "#";
                            }
                        } else if (leftRightCheck > 0){
                            for (int a = 0; a < Math.abs(leftRightCheck); a++){
                                cave[Integer.valueOf(holder1[0])][Integer.valueOf(holder1[1])+a] = "#";
                            }
                        } else if (leftRightCheck < 0){
                            for (int a = 0; a < Math.abs(leftRightCheck); a++){
                                cave[Integer.valueOf(holder1[0])][Integer.valueOf(holder1[1])-a] = "#";
                            }
                        } 
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            
            for (int i = 0; i < 50; i++){
                for (int a = 0; a < 30; a++){
                    if (cave[i][a] == null){
                        cave[i][a] = ".";
                    }
                }
            }
            printCave(cave);
            
            
            
            
            boolean moreSand = true;
            boolean moreMovement = true;
            int[] sandPostition = {500, 0};
            int solution = 0;
            while (moreSand){
                sandPostition[0] = 500; sandPostition[1] = 0;
                solution++;
                while (moreMovement){
                    if (map.get(Integer.toString(sandPostition[0]-1)+ ","+ sandPostition[1]) == null){
                        sandPostition[0]--;
                    } else if (map.get(Integer.toString(sandPostition[0]-1)+ ","+ Integer.toString(sandPostition[1]-1)) == null){
                        sandPostition[0]--;
                        sandPostition[1]++;
                    } else if (map.get(Integer.toString(sandPostition[0]-1)+ ","+ Integer.toString(sandPostition[1]+1)) == null){
                        sandPostition[0]--;
                        sandPostition[1]++;
                    } else {
                        map.put(sandPostition[0] + "," + sandPostition[1], "O");
                        moreMovement = false;
                    }
                    if (sandPostition[0] <= 0){
                        moreSand = false;
                    }
                    //System.out.println(sandPostition[0]+ " " + sandPostition[1]);
                    moreSand = false;
                    moreMovement = false;

                }
            }

            //System.out.println(solution);
            
        }

        public static void printCave(String[][] cave){
            for (String[] row : cave){
                for (String item : row){
                    System.out.print(item);
                }
                System.out.println();
            }
        }
}