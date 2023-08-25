import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


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
                            //System.out.println("Left Location: "+ i + " "+ counter + " Value: "+value+" Result: " + larger);
                            counter++;
                        }
                        if (larger && goodTree){//actualy add to total if visible all the way
                            solution++;
                            goodTree = false;
                            //System.out.println("Left Location: "+ i + " "+ a);
                        }

                        //This will loop to check visible from the right
                        larger = true;
                        counter = a + 1;
                        while (larger &&  sizeOfForest > counter && goodTree){
                            if (value <= forest[i][counter]){
                                larger = false;
                            }
                            //System.out.println("Right Location: "+ i + " "+ counter + " Value: "+value+" Result: " + larger);
                            counter++;
                        }
                        if (larger && goodTree){
                            solution++;
                            goodTree = false;
                            //System.out.println("Right Location: "+ i + " "+ a);
                        }

                        //This will loop to check visible from up
                        counter = 0;
                        larger = true;
                        while (larger && i > counter && goodTree){
                            
                            if (value <= forest[counter][a]){
                                larger = false;
                            }
                            //System.out.println("Up Location: "+ counter + " "+ a+ " Value: "+value+" Result: " + larger);
                            counter++;
                        }
                        if (larger && goodTree){
                            solution++;
                            goodTree = false;
                            //System.out.println("Up Location: "+ i + " "+ a);
                        }

                        //Check from down
                        larger = true;
                        counter = i + 1;
                        while (larger &&  sizeOfForest > counter && goodTree){
                            
                            if (value <= forest[counter][a]){
                                larger = false;
                            }
                            //System.out.println("Down Location: "+ counter + " "+ a+ " Value: "+value+" Result: " + larger);
                            counter++;
                        }
                        if (larger && goodTree){
                            solution++;
                            goodTree = false;
                            //System.out.println("Down Location: "+ i + " "+ a);
                        }
                        //System.out.println();
                    }
                }
            }
            
            System.out.println(solution);
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

            int score = 0;
            ArrayList<Integer> solutionHolder = new ArrayList<>();
            int solution = 0;
            counter = 0;
            boolean larger = true;
            boolean goodTree = true;
            boolean check = true;
            int value = 0;
            for (int i = 0; i < sizeOfForest; i++){
                for (int a = 0; a < sizeOfForest; a++){ //This will check all the trees through this code
                    if (i == 0 || a == 0 || i == sizeOfForest-1 || a == sizeOfForest-1){ //If tree is on the outside
                        
                    } else {
                        value = forest[i][a];
                        larger = true;
                        goodTree = true;
                        check = true;
                        score = 0;

                        // Looks left
                        counter = a-1;
                        while (larger && 0 <= counter && goodTree){
                            if (value <= forest[i][counter]){
                                larger = false;
                            } else {
                                score++;
                            }
                            counter--;
                        }
                        solutionHolder.add(score);
                        score = 0;

                        //This will loop to check visible from the right
                        larger = true;
                        counter = a + 1;
                        while (larger &&  sizeOfForest > counter && goodTree){
                            if (value <= forest[i][counter]){
                                larger = false;
                            } else {
                                score++;
                            }
                            //System.out.println("Right Location: "+ i + " "+ counter + " Value: "+value+" Result: " + larger);
                            counter++;
                        }
                        solutionHolder.add(score);
                        score = 0;

                        //This will loop to check visible from up
                        larger = true;
                        counter = a-1;
                        while (larger && 0 <= counter && goodTree){
                            if (value <= forest[counter][a]){
                                larger = false;
                            } else {
                                score++;
                            }
                            counter--;
                        }
                        solutionHolder.add(score);
                        score = 0;
                        

                        //Check from down
                        larger = true;
                        counter = i + 1;
                        while (larger &&  sizeOfForest > counter && goodTree){
                            
                            if (value <= forest[counter][a]){
                                larger = false;
                            } else {
                                score++;
                            }
                            //System.out.println("Down Location: "+ counter + " "+ a+ " Value: "+value+" Result: " + larger);
                            counter++;
                        }
                        solutionHolder.add(score);
                        score = 0;

                        //Checks largest score so far
                        int holder = 0;
                        for (int s : solutionHolder){
                            holder = holder * s;
                        }
                        if (holder > solution){
                            solution = holder;
                        }
                        solutionHolder.clear();
                        //System.out.println();
                    }
                }
            }
            
            System.out.println(solution);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
