package org.y2023.day10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Day10 {
    // Load data into 2d array. Define directions of movement.
    // store the start point
    // Don't need a graph just a path
    // The path needs location and connections

    public static void main(String[] args) {
        try {
            String input = "lib/src/main/java/org/y2023/resources/day.txt";
            System.out.println("Part1: " + part1(input));
            // System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int part1(String input) throws IOException {
        String line = "";
        List<char[]> grid = new ArrayList<>();
        Scanner scanner = new Scanner(new File(input));

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            grid.add(line.toCharArray());

        }
        scanner.close();
        return 0;
    }

    public static int part2(String input) throws IOException {
        String line = "";
        Scanner scanner = new Scanner(new File(input));
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

        }
        scanner.close();
        return 0;
    }
}