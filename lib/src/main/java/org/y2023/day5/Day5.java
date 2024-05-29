package org.y2023.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {
    public static void main(String[] args) {
        try {
            part1("lib/src/main/resources/y2023/day5.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static int part1(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line;
        List<Integer> seeds = new ArrayList<>();
        Map<Integer, Integer> seedSoil = new HashMap<>();

        seeds.addAll(List.of(reader.readLine().split(" ")).stream().map(Integer::parseInt).toList());
        reader.readLine();
        reader.readLine();


        for (int i = 0; i < 7; i++) {
            while ((line = reader.readLine()) != null) {
                seedSoil.put(i, Integer.parseInt(line));
            }
            seedSoil.clear();
        }
        return 0;
    }
}
