package org.y2023.day6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Day6 {

    public static void main(String[] args) {
        try {
            String input = "lib/src/main/java/org/y2023/resources/day6.txt";
            System.out.println("Part1: " + part1(input));
            System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static long part1(String input) throws IOException {
            Scanner scanner = new Scanner(new File(input));
            
            int[] time = Arrays.stream(scanner.nextLine().substring(9).trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] distance = Arrays.stream(scanner.nextLine().substring(9).trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int result = 1;

            for (int i = 0; i < time.length; i++) {
                result *= options(time[i], distance[i]);
            }
            


            scanner.close();
            return result;
    }

    public static int options(int time, int distance) {
        // How long you hold at start is the speed you travers the whole distance
        int times = 0;
        for (int i = 1; i < time; i++) {
            if ((time - i) * i > distance) {
                times++;
            }
        }

        return times;
    }

    public static long part2(String input) throws IOException {
        Scanner scanner = new Scanner(new File(input));
        
        long time = Long.parseLong(scanner.nextLine().substring(9).replaceAll("\\s", ""));
        long distance = Long.parseLong(scanner.nextLine().substring(9).replaceAll("\\s", ""));

        long times = 0;
        for (int i = 1; i < time; i++) {
            if ((time - i) * i > distance) {
                times++;
            }
        }

        scanner.close();
        return times;
    }
}