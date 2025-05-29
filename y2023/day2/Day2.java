package org.y2023.day2;

import java.io.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        String input_file = "lib/src/main/resources/y2023/day2.txt";
        System.out.println(part1(input_file));
        System.out.println(part2(input_file));
    }

    public static int part1(String input_file) throws IOException {
        int total = 0;
        BufferedReader reader = new BufferedReader(new FileReader(input_file));
        String line;
        while ((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line.substring(5, line.indexOf(":")));
            line = line.substring(line.indexOf(":") + 2);
            boolean valid = true;
            for (String round : line.split(";")) {
                round = round.trim();
                for (String draw : round.split(",")) {
                    draw = draw.trim();
                    String color = draw.substring(draw.indexOf(" ") + 1);
                    int value = Integer.parseInt(draw.substring(0, draw.indexOf(" ")));
                    if ((color.equals("blue") && value > 14) || (color.equals("green") && value > 13) || (color.equals("red") && value > 12)) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) break;
            }
            if (valid) total += number;
        }
        reader.close();
        return total;
    }

    public static int part2(String input_file) throws IOException {
        int total = 0;
        BufferedReader reader = new BufferedReader(new FileReader(input_file));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.substring(line.indexOf(":") + 2);
            int red = 0, green = 0, blue = 0;
            for (String round : line.split(";")) {
                round = round.trim();
                for (String draw : round.split(",")) {
                    draw = draw.trim();
                    String color = draw.substring(draw.indexOf(" ") + 1);
                    int value = Integer.parseInt(draw.substring(0, draw.indexOf(" ")));
                    if (color.equals("blue") && value > blue) blue = value;
                    else if (color.equals("green") && value > green) green = value;
                    else if (color.equals("red") && value > red) red = value;
                }
            }
            total += red * blue * green;
        }
        reader.close();
        return total;
    }
}