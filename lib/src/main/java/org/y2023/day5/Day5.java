package org.y2023.day5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        try {
            System.out.println(part1("lib/src/main/java/org/y2023/resources/day5.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    // dest start range
    public static long part1(String input) throws IOException {
        Scanner scanner = new Scanner(new File(input));
        String line;
        List<Long> seeds = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();


        seeds.addAll(List.of(scanner.nextLine().substring(7).split(" ")).stream().map(Long::parseLong).toList());
        visited.addAll(Collections.nCopies(seeds.size(), false));

			while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.equals("")) {
                    continue;
                } else if (line.contains("-")) {
                    Collections.fill(visited, false);
                    // System.out.println("Line: " + line);
                    // System.out.println("Seeds: " + seeds.get(2) + "\n");
                    continue;
                }

                String[] split = line.split(" ");

                long start = Long.parseLong(split[1]);
                long conversion = Long.parseLong(split[0]) - start;
                long max = Long.parseLong(split[2]) + start;

                for (int i = 0; i < seeds.size(); i++) {
                    Long seed = seeds.get(i);
                    if (seed >= start && seed <= max && !visited.get(i)) {
                        visited.set(i, true);
                        seeds.set(i, conversion + seed);
                    }
                }
            }

        System.out.println("Location: " + seeds + "\n");
        scanner.close();
        seeds.sort((a, b) -> Long.compare(a, b));
        return seeds.get(0);
    }
}
