package org.y2023.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8 {
    public static void main(String[] args) {
        try {
            String input = "lib/src/main/java/org/y2023/resources/day8.txt";
            System.out.println("Part1: " + part1(input));
            System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int part1(String input) throws IOException {
        Map<String, Node> nodes = new HashMap<>();
        String instructions = "";
        try {
            Scanner scanner = new Scanner(new File(input));
            instructions = scanner.nextLine();

            while (scanner.hasNextLine()) {
                Pattern pattern = Pattern.compile("([A-Z]+) = \\(([A-Z]+), ([A-Z]+)\\)");
                Matcher matcher = pattern.matcher(scanner.nextLine());
                if (matcher.find()) {
                    nodes.put(matcher.group(1),
                    new Node(matcher.group(1),
                        matcher.group(2),
                        matcher.group(3)));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int steps = 0;
        String current = "AAA";
        while (true) {
            for (char c : instructions.toCharArray()) {
                if (c == 'L') {
                    current = nodes.get(current).leftId;
                } else {
                    current = nodes.get(current).rightId;
                }
                steps++;
                if (current.equals("ZZZ")) {
                    return steps;
                }
            }
        }
    }

    public static long part2(String input) throws IOException {
        Map<String, Node> nodes = new HashMap<>();
        Scanner scanner = new Scanner(new File(input));
        char[] instructions = scanner.nextLine().toCharArray();

        while (scanner.hasNextLine()) {
            Pattern pattern = Pattern.compile("([A-Z0-9]+) = \\(([A-Z0-9]+), ([A-Z0-9]+)\\)");
            Matcher matcher = pattern.matcher(scanner.nextLine());
            if (matcher.find()) {
                nodes.put(matcher.group(1),
                new Node(matcher.group(1),
                    matcher.group(2),
                    matcher.group(3)));
            }
        }
        scanner.close();

        long steps = 0;
        List<String> current = new ArrayList<>();

        for(String id : nodes.keySet()) {
            if (id.endsWith("A")) {
                current.add(id);
            }
        }

        List<Long> pathLengths = new ArrayList<>();
        while (current.size() > 0) {
            for (char c : instructions) {
                if (c == 'L') {
                    for (int i = 0; i < current.size(); i++) {
                        current.set(i, nodes.get(current.get(i)).leftId);
                    }
                } else {
                    for (int i = 0; i < current.size(); i++) {
                        current.set(i, nodes.get(current.get(i)).rightId);
                    }
                }
                steps++;

                for (int i = 0; i < current.size(); i++) {
                    if (current.get(i).endsWith("Z")) {
                        pathLengths.add(steps);
                        current.remove(i);
                    }
                }
            }
        }

        return lcmOfList(pathLengths);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcmOfList(List<Long> values) {
        long result = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            result = (result / gcd(result, values.get(i))) * values.get(i);
        }
        return result;
    }
}