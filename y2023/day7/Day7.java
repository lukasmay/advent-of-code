package org.y2023.day7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Day7 {

    public static final List<Character> cardValues = Arrays.asList('A', 'K', 'Q', 'T', '9', '8', '7', '6', '5', '4', '3', '2', 'J');
    public static void main(String[] args) {
        try {
            String input = "lib/src/main/java/org/y2023/resources/day7.txt";
            System.out.println("Part2: " + parts(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static long parts(String input) throws IOException {
        String line[];
        List<Hand> hands = new ArrayList<>();
        Scanner scanner = new Scanner(new File(input));
        while (scanner.hasNextLine()) {
            line = scanner.nextLine().split(" ");
            hands.add(new Hand(line[0], Integer.parseInt(line[1])));
        }
        scanner.close();

        hands.sort((h1, h2) -> {
            if (h1.getHandType().getStrength() > h2.getHandType().getStrength()) {
                return 1;
            } else if (h1.getHandType().getStrength() < h2.getHandType().getStrength()) {
                return -1;
            } else {
                for (int i = 0; i < h1.getCards().length(); i++) {
                    if (cardValues.indexOf(h1.getCard(i)) == cardValues.indexOf(h2.getCard(i))) {
                        continue;
                    } else {
                        return cardValues.indexOf(h2.getCard(i)) - cardValues.indexOf(h1.getCard(i));
                    }
                }
            }
            return 0;
        });
        // hands.stream().forEach(h -> System.out.println(h.getCards() + ": " + h.getHandType()));

        int sum = 0;
        for (int i = 0; i < hands.size(); i++) {
            sum += hands.get(i).getBid() * (i + 1);
        }

        return sum;
    }
}
