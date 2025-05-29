package org.y2023.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException {
        String input_file = "lib/src/main/resources/y2023/day3.txt";
        System.out.println(part1(input_file));
        System.out.println(part2(input_file));
    }

    public static List<Part> getNumberLocations(List<char[]> engine) {
        List<Part> numberLocation = new ArrayList<>();
        for (int i = 0; i < engine.size(); i++) {
            String number = "";
            List<int[]> location = new ArrayList<>();
            for (int a = 0; a < engine.get(i).length; a++) {
                if (Character.isDigit(engine.get(i)[a])) {
                    number += engine.get(i)[a];
                    location.add(new int[]{i, a});
                    if (a == engine.get(i).length - 1) {
                        numberLocation.add(new Part(Integer.parseInt(number), location));
                    }
                } else {
                    if (!number.equals("")) {
                        numberLocation.add(new Part(Integer.parseInt(number), location));
                    }
                    number = "";
                    location = new ArrayList<>();
                }
            }
        }
        return numberLocation;
    }

    public static List<char[]> getEngine(String inputFile) throws IOException {
        List<char[]> engine = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            engine.add(line.toCharArray());
        }
        reader.close();
        return engine;
    }

    public static int part1(String inputFile) throws IOException {
        List<char[]> engine = getEngine(inputFile);
        List<Part> numberLocation = getNumberLocations(engine);

        List<int[]> symbolLocation = new ArrayList<>();
        for (int i = 0; i < engine.size(); i++) {
            for (int a = 0; a < engine.get(i).length; a++) {
                if (!Character.isDigit(engine.get(i)[a]) && engine.get(i)[a] != '.') {
                    if (engine.get(i)[a] != '\n') {
                        symbolLocation.add(new int[]{i, a});
                    }
                }
            }
        }

        int total = 0;
        for (Part num : numberLocation) {
            for (int[] loc : num.locations) {
                for (int[] sym : symbolLocation) {
                    if (Math.abs(loc[0] - sym[0]) <= 1 && Math.abs(loc[1] - sym[1]) <= 1) {
                        total += num.number;
                        break;
                    }
                }
            }
        }

        return total;
    }

    public static int part2(String inputFile) throws IOException {
        List<char[]> engine = getEngine(inputFile);
        List<Part> numberLocation = getNumberLocations(engine);

        List<int[]> symbolLocation = new ArrayList<>();
        for (int i = 0; i < engine.size(); i++) {
            for (int a = 0; a < engine.get(i).length; a++) {
                if (engine.get(i)[a] == '*') {
                    symbolLocation.add(new int[]{i, a});
                }
            }
        }

        int total = 0;
        List<Part> count = new ArrayList<>();

        for (int[] sym : symbolLocation) {
            for (Part num : numberLocation) {
                for (int[] loc : num.locations) {
                    if (Math.abs(loc[0] - sym[0]) <= 1 && Math.abs(loc[1] - sym[1]) <= 1) {
                        count.add(num);
                        break;
                    }
                }
            }
            if (count.size() == 2) {
                total += count.get(0).number * count.get(1).number;
            }
            count.clear();
        }

        return total;
    }
}