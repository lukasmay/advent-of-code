package org.y2023.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        String input_file = "lib/src/main/resources/y2023/day4.txt";
        System.out.println(part1(input_file));
        System.out.println(part2(input_file));
    }

    public static int part1(String inputFile) throws IOException {
        List<Card> cards = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            cards.add(new Card(line));
        }

        int total = 0;
        for (Card card : cards) {
            total += card.score;
        }
        reader.close();
        return total;
    }

    public static int part2(String inputFile) throws IOException {
        List<Card> cards = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            cards.add(new Card(line));
        }

        int total = 0;
        for (int z = 0; z < cards.size(); z++) {
            total += cards.get(z).number;
            for (int i = 0; i < cards.get(z).number; i++) {
                for (int a = 1; a <= cards.get(z).amount; a++) {
                    cards.get(z + a).number += 1;
                }
            }
        }
        reader.close();
        return total;
    }
}
