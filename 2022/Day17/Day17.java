import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day17{
    /* Have a brick class to store all the peices locations. 
     * This allows me to bypass the harder check. 
     * The check allows me to make 
     */

    public static void main(String[] args) {

    		part1();
    		//part2();
    	}

        public static void part1(){
            try {
                Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day17.txt"));
                while (scanner.hasNextLine()) {
                    char[] line = scanner.nextLine().toCharArray();
                    int rockType = 0;
                    ArrayList<Character[]> map = new ArrayList<>();
                    Character[] row = new Character[7];
                    int highestPoint = 0;
                    boolean stillMove = true;
                    for (int i = 0; i < 4; i++){
                        map.add(new Character[7]);
                        for (int a = 0; a < 7; a++){
                            if (i == 1){
                                map.get(i)[a] = '#';
                            } else {
                                map.get(i)[a] = '.';
                            }
                        }
                    }
                    for (int i = 0; i < 2022; i++){
                        while (stillMove){
                            //
                        }
                    }

                    

                }
            scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static char[][] getRock(int type){
            char[][] rock = new char[4][4];
            switch (type){
                case 1:
                    rock[0][0] = '#';
                    rock[0][1] = '#';
                    rock[0][2] = '#';
                    rock[0][3] = '#';
                    break;
                case 2:
                    rock[1][0] = '#';
                    rock[0][1] = '#';
                    rock[1][1] = '#';
                    rock[1][2] = '#';
                    rock[2][1] = '#';
                    break;
                case 3:
                    rock[0][2] = '#';
                    rock[1][2] = '#';
                    rock[2][2] = '#';
                    rock[2][1] = '#';
                    rock[2][0] = '#';
                    break;
                case 4:
                    rock[0][0] = '#';
                    rock[0][1] = '#';
                    rock[0][2] = '#';
                    rock[0][3] = '#';
                    break;
                case 5:
                    rock[0][0] = '#';
                    rock[0][1] = '#';
                    rock[1][0] = '#';
                    rock[1][1] = '#';
                    break;
            }
            for (int i = 0; i < 4; i++){
                for (int a = 0; a < 4; a++){
                    if (rock[i][a] != '#'){
                        rock[i][a] = '.';
                    }
                }
            }

            return rock;
        }
}