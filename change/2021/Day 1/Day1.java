import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.*;

public class Day1 {
    public static void main(String[] args) {
		part1();
	}

    public static void part1(){
        int prevous = 0;
        int current = 0;
        int total = 0;
        try {
            Scanner scanner = new Scanner(new File("2021/input/day1.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                current = Integer.valueOf(line);
                if (current > prevous){
                    total++;
                }
                prevous = current;


            }
            System.out.println(total-1);
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }


    
}
