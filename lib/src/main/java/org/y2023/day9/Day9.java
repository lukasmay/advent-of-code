package org.y2023.day9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day9 {

    public static void main(String[] args) {
        try {
            String input = "lib/src/main/java/org/y2023/resources/day9.txt";
            System.out.println("Part1: " + part1(input));
            System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int part1(String input) throws IOException {
        Scanner scanner = new Scanner(new File(input));
        int sum = 0;
        while (scanner.hasNextLine()) {
            List<List<Integer>> patterns = new ArrayList<>();
            patterns.add(new ArrayList<>());
            for (String s : scanner.nextLine().split(" ")) {
                patterns.get(0).add(Integer.parseInt(s));
            }

            while (patterns.get(0).stream().distinct().count() > 1) {
                List<Integer> currentPattern = patterns.get(0);
                List<Integer> nextPattern = IntStream.range(0, currentPattern.size()-1)
                                                    .mapToObj(i -> (currentPattern.get(i+1) - currentPattern.get(i)))
                                                    .collect(Collectors.toList());
                patterns.add(0, nextPattern);
                
            }
            
            for (int i = 0; i < patterns.size()-1; i++) {
                patterns.get(i+1).add(patterns.get(i+1).get(patterns.get(i+1).size()-1) +  patterns.get(i).get(patterns.get(i).size()-1));
            }

            sum += patterns.get(patterns.size()-1).get(patterns.get(patterns.size()-1).size()-1);
        }
        scanner.close();
        return sum;
    }

    public static int part2(String input) throws IOException {
        Scanner scanner = new Scanner(new File(input));
        int sum = 0;
        while (scanner.hasNextLine()) {
            List<List<Integer>> patterns = new ArrayList<>();
            patterns.add(new ArrayList<>());
            for (String s : scanner.nextLine().split(" ")) {
                patterns.get(0).add(Integer.parseInt(s));
            }

            while (patterns.get(0).stream().distinct().count() > 1) {
                List<Integer> currentPattern = patterns.get(0);
                List<Integer> nextPattern = IntStream.range(0, currentPattern.size()-1)
                                                    .mapToObj(i -> (currentPattern.get(i+1) - currentPattern.get(i)))
                                                    .collect(Collectors.toList());
                patterns.add(0, nextPattern);
                
            }

            for (int i = 0; i < patterns.size()-1; i++) {
                patterns.get(i+1).add(0, patterns.get(i+1).get(0) -  patterns.get(i).get(0));
            }

            sum += patterns.get(patterns.size()-1).get(0);
        }
        scanner.close();
        return sum;
    }
}