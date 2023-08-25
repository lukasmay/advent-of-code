import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Day12 {
    public static void main(String[] args) {
        
        
		part1();
		//part2();
	}

    public static void part1(){
        String line = "";
        char[][] map = new char[5][5];
        int a = 0;
        int xE,yE,xS,yS = 0;
        try {
            Scanner scanner = new Scanner(new File("/Users/lukasmay/Documents/Github/AdventOfCode/2022/input/day12.txt"));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                map[a] = line.toCharArray();
                int i = 0;
                for (Character letter : map[a]){
                    if (letter == 'S'){
                        xS = a;
                        yS = i;
                    } else if (letter == 'E'){
                        xE = a;
                        yE = i;
                    }
                }
                a++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Loop through all paths
        HashMap<Integer, String> paths = new HashMap<>();
       
    }
    
}
