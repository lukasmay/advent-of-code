package org.y2022.day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day15{

    public static void main(String[] args) {

    		part1();
    		//part2();
    	}

        public static void part1(){
            String line = "";
            String sencor = "";
            String beacon = "";
            int maxX = 0;
            int maxY = 0;
            int minX = 0;
            int minY = 0;
            ArrayList<Integer[]> location = new ArrayList<>();
            try {
                Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day15.txt"));
                Integer[] sencorLocation = {0, 0};
                Integer[] beaconLocation = {0, 0};
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    sencor = line.substring(10, line.indexOf(":"));
                    beacon = line.substring(line.lastIndexOf("x"));

                    sencorLocation[0] = Integer.valueOf(sencor.substring(sencor.indexOf("="), sencor.indexOf(",")));
                    sencorLocation[1] = Integer.valueOf(sencor.substring(sencor.lastIndexOf("=")));
                    
                    beaconLocation[0] = Integer.valueOf(beacon.substring(beacon.indexOf("="), beacon.indexOf(",")));
                    beaconLocation[1] = Integer.valueOf(beacon.substring(beacon.lastIndexOf("=")));

                    location.add(sencorLocation);
                    location.add(beaconLocation);

                    if (maxX < sencorLocation[0]){
                        maxX = sencorLocation[0];
                    } else if (maxX < beaconLocation[0]){
                        maxX = beaconLocation[0];
                    } else if (maxY < beaconLocation[1]){
                        maxY = beaconLocation[1];
                    } else if (maxY < sencorLocation[1]){
                        maxY = sencorLocation[1];
                    } else if (minX > beaconLocation[0]){
                        minX = beaconLocation[0];
                    } else if (minX > sencorLocation[0]){
                        minX = sencorLocation[0];
                    } else if (minY > beaconLocation[1]){
                        minY = beaconLocation[1];
                    } else if (minY > beaconLocation[1]){
                        minY = beaconLocation[1];
                    }
                }
            scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int width = Math.abs(maxX - minX);
            int height = Math.abs(maxY - minY); 
            int distance = 0;
            int mover = 0;
            int level = 0;
            String[][] map = new String[width][height];

            //for all the values subtract the minX and Y to make those 0.
            for (int i = 0; i < location.size()-1; i++){
                distance = Math.abs(location.get(i)[0] - location.get(i+1)[0]) + Math.abs(location.get(i)[1] - location.get(i+1)[1]);
                
                /* I need to create a loop to create the area
                        Loop through by finding the position of a tip and then go down one and add two more to either side
                 * Then I need to check how many out of the line are known 
                 *      Might have to add minimum back to it. 
                 */

                // for the upper side of the area
                for (int a = 0; a < distance; a++){
                    level = distance - 1;// the incriment to *2 and subtract from distance to go up one in rows to make #
                    for (int z = level/-2; z < level/2; z++){
                        map[location.get(i)[0]-minX+z][location.get(i)[1]-minY+a] = "#";//Not tested but should work
                        // the z should start -some length away 1 higher each time
                    }
                    
                }
                // For the underside of the area
                for (int a = 0; a < distance; a++){
                    level = distance - 1;
                    for (int z = 0; z < level; z++){
                        map[location.get(i)[0]-minX+mover][location.get(i)[1]-minY+mover] = "#";//Doesn't work
                    }
                    
                }
                i++;
            }

        }

        
}