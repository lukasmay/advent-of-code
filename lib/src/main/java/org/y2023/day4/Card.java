package org.y2023.day4;

public class Card {
    int id;
    int score;
    int number;
    int amount;

    Card(String line) {
        String[] parts = line.split(":");
        String[] winCards = parts[1].split("\\|")[0].trim().split(" ");
        String[] cards = parts[1].split("\\|")[1].trim().split(" ");

        int count = 0;
        for (String card : cards) {
            if (card.equals("")) continue;
            for (String winCard : winCards) {
                if (card.equals(winCard)) {
                    count++;
                    break;
                }
            }
        }

        this.id = Integer.parseInt(parts[0].substring(5).trim());        this.score = count > 0 ? (int) Math.pow(2, count - 1) : 0;
        this.number = 1;
        this.amount = count;
    }

    @Override
    public String toString() {
        return "Card: " + id + " Score: " + score + " Count: " + number;
    }
}
