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
            String input = "lib/src/main/java/org/y2023/resources/day5.txt";
            System.out.println("Part1: " + part1(input));
            System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

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
                long max = Long.parseLong(split[2]) + start - 1;

                for (int i = 0; i < seeds.size(); i++) {
                    Long seed = seeds.get(i);
                    if (seed >= start && seed <= max && !visited.get(i)) {
                        visited.set(i, true);
                        seeds.set(i, conversion + seed);
                    }
                }
            }

        // System.out.println("Location: " + seeds + "\n");
        scanner.close();
        seeds.sort((a, b) -> Long.compare(a, b));
        return seeds.get(0);
    }

    public static long part2(String input) throws IOException {
        Scanner scanner = new Scanner(new File(input));
        String line;
        List<SeedRange> seeds = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();


        // seeds.addAll(List.of(scanner.nextLine().substring(7).split(" ")).stream().map(Long::parseLong).toList());
        

        List<Long> seedRanges = List.of(scanner.nextLine().substring(7).split(" ")).stream().map(Long::parseLong).toList();
        for (int i = 0; i < seedRanges.size(); i += 2) {
            seeds.add(new SeedRange(seedRanges.get(i), seedRanges.get(i) + seedRanges.get(i + 1) - 1));
        }
        visited.addAll(Collections.nCopies(seeds.size(), false));
        // System.out.println("Seeds: " + seeds + "\n");

			while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.equals("")) {
                    continue;
                } else if (line.contains("-")) {
                    Collections.fill(visited, false);
                    // System.out.println("Line: " + line);
                    // System.out.println("Seeds: " + seeds + "\n");
                    continue;
                }

                String[] split = line.split(" ");

                long start = Long.parseLong(split[1]);
                long conversion = Long.parseLong(split[0]) - start;
                long max = Long.parseLong(split[2]) + start - 1;

                int i = 0;
                while (i < seeds.size()) {
                    SeedRange seed = seeds.get(i);
                    Overlap overlap = seed.contains(start, max);
                    if (visited.get(i)) {
                        i++;
                        continue;
                    } else if (overlap.equals(Overlap.FULL)) {
                        seeds.get(i).fullConversion(conversion);
                        visited.set(i, true);
                    } else if (overlap.equals(Overlap.PARTIAL)) { // Range is in seed
                        if (start > seed.getMin() && max < seed.getMax()) {
                            seeds.add(new SeedRange(seed.getMin(), start - 1));
                            seeds.add(new SeedRange(max + 1, seed.getMax()));
                            visited.add(false);
                            visited.add(false);
                            seeds.get(i).setMinMax(start + conversion, max + conversion);
                            visited.set(i, true);
                        } else if (start <= seed.getMin()) { // Low end out of range and high end in range
                            seeds.add(new SeedRange(max + 1, seed.getMax()));
                            visited.add(false);
                            seeds.get(i).setMinMax(seed.getMin() + conversion, max + conversion);
                            visited.set(i, true);
                        } else if (max >= seed.getMax()) { // Low end in range and high end out of range
                            seeds.add(new SeedRange(seed.getMin(), start - 1));
                            visited.add(false);
                            seeds.get(i).setMinMax(start + conversion, seed.getMax() + conversion);
                            visited.set(i, true);
                        } else {
                            System.out.println("Error: " + seed + " " + start + " " + max);
                        }
                    }
                    // System.out.println("Seeds: " + seeds + "\n");
                    i++;
                }
            }

        // System.out.println("Location: " + seeds + "\n");
        scanner.close();
        seeds.sort((a, b) -> Long.compare(a.getMin(), b.getMin()));
        return seeds.get(0).getMin();
    }

    enum Overlap {
        NONE, FULL, PARTIAL
    }
}
