package org.y2022.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day8 {
    public static void main(String[] args) {
        int sizeOfForest = 99;
		part1(sizeOfForest);
		part2(sizeOfForest);
	}

    public static void part1(int sizeOfForest){
        String line = "";
        int counter = 0;
        int totalCounter = 0; //Total number of trees in forest
        int[][] forest = new int[sizeOfForest][sizeOfForest];
        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day8.txt"));
            while (scanner.hasNextLine()) {
                //Adding Rows to forest
                line = scanner.nextLine();
                char[] ch = line.toCharArray();
                for (int i = 0; i < ch.length; i++){
                    forest[counter][i] = Character.getNumericValue(ch[i]);
                    totalCounter++;
                }
                counter++;
            }
            int solution = 0;
            counter = 0;
            boolean larger = true;
            boolean goodTree = true;
            int value = 0;
            for (int i = 0; i < sizeOfForest; i++){
                for (int a = 0; a < sizeOfForest; a++){ //This will check all the trees through this code
                    if (i == 0 || a == 0 || i == sizeOfForest-1 || a == sizeOfForest-1){ //If tree is on the outside
                        solution++;
                    } else {
                        value = forest[i][a];
                        counter = 0;
                        larger = true;
                        goodTree = true;

                        // This will loop to check if the tree is visible from the left
                        while (larger && a > counter && goodTree){
                            if (value <= forest[i][counter]){
                                larger = false;
                            }
                            counter++;
                        }
                        if (larger && goodTree){//actualy add to total if visible all the way
                            solution++;
                            goodTree = false;
                        }

                        //This will loop to check visible from the right
                        larger = true;
                        counter = a + 1;
                        while (larger &&  sizeOfForest > counter && goodTree){
                            if (value <= forest[i][counter]){
                                larger = false;
                            }
                            counter++;
                        }
                        if (larger && goodTree){
                            solution++;
                            goodTree = false;
                        }

                        //This will loop to check visible from up
                        counter = 0;
                        larger = true;
                        while (larger && i > counter && goodTree){
                            
                            if (value <= forest[counter][a]){
                                larger = false;
                            }
                            counter++;
                        }
                        if (larger && goodTree){
                            solution++;
                            goodTree = false;
                        }

                        //Check from down
                        larger = true;
                        counter = i + 1;
                        while (larger &&  sizeOfForest > counter && goodTree){
                            
                            if (value <= forest[counter][a]){
                                larger = false;
                            }
                            counter++;
                        }
                        if (larger && goodTree){
                            solution++;
                            goodTree = false;
                        }
                    }
                }
            }
            
            System.out.println("Part 1: " + solution);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void part2(int sizeOfForest){
        String line = "";
        int counter = 0;
        int[][] forest = new int[sizeOfForest][sizeOfForest];
        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day8.txt"));
            while (scanner.hasNextLine()) {
                //Adding Rows to forest
                line = scanner.nextLine();
                char[] ch = line.toCharArray();
                for (int i = 0; i < ch.length; i++){
                    forest[counter][i] = Character.getNumericValue(ch[i]);
                }
                counter++;
            }
            
            int leftScore, rightScore, upScore, downScore = 0;
            int solution = 0;
            counter = 0;
            boolean larger = true;
            int value = 0;

            for (int i = 0; i < sizeOfForest; i++){
                for (int a = 0; a < sizeOfForest; a++){ //This will check all the trees through this code
                    if (i == 0 || a == 0 || i == sizeOfForest-1 || a == sizeOfForest-1){ //If tree is on the outside

                    } else {
                        value = forest[i][a];
                        larger = true;
                        leftScore = 0;
                        rightScore = 0;
                        upScore = 0;
                        downScore = 0;

                        // Looks left
                        counter = a-1;
                        while (larger && (0 <= counter)){
                            if (value <= forest[i][counter]){
                                larger = false;
                            } 
                            leftScore++;
                            counter--;
                        }

                        // Looks Right
                        larger = true;
                        counter = a + 1;
                        while (larger &&  (sizeOfForest > counter)){
                            if (value <= forest[i][counter]){
                                larger = false;
                            }
                            rightScore++;
                            counter++;
                        }

                        // Looks Up
                        larger = true;
                        counter = i - 1;
                        while (larger && (0 <= counter)){
                            if (value <= forest[counter][a]){
                                larger = false;
                            }
                            upScore++;
                            counter--;
                        }
                        

                        // Looks Down
                        larger = true;
                        counter = i + 1;
                        while (larger &&  sizeOfForest > counter){
                            
                            if (value <= forest[counter][a]){
                                larger = false;
                            } 
                            downScore++;
                            counter++;
                        }

                        //Checks largest score so far
                        int holder = leftScore * rightScore * upScore * downScore;

                        if (holder > solution){
                            solution = holder;
                        }
                    }
                }
            }
            
            System.out.println("Part 2: " + solution);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
