package org.y2023.day7;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import org.checkerframework.checker.units.qual.C;

public class Hand {
    private String cards;
    private HandType handType;
    private int bid;

    public Hand(String cards, int bid) {
        this.cards = cards;
        this.bid = bid;

        Map<Character, Integer> handTypeCount = new HashMap<>();
        int jCount = 0;
        for (char card : cards.toCharArray()) {
            if (card == 'J') {
                jCount++;
            } else {
                handTypeCount.put(card, handTypeCount.getOrDefault(card, 0) + 1);
            }
            // System.out.println(handTypeCount);
        }
        for (char card : handTypeCount.keySet()) {
            handTypeCount.put(card, handTypeCount.get(card) + jCount);
        }

        if (handTypeCount.containsValue(5)) {
            this.handType = HandType.FIVE_OF_A_KIND;
        } else if (handTypeCount.containsValue(4)) {
            this.handType = HandType.FOUR_OF_A_KIND;
        } else if (handTypeCount.containsValue(3)) {
            this.handType = handTypeCount.containsValue(2) ? HandType.FULL_HOUSE : HandType.THREE_OF_A_KIND;
        } else if (handTypeCount.containsValue(2)) {
            if (handTypeCount.values().stream().filter(v -> v == 2).count() == 2) {
                this.handType = HandType.TWO_PAIR;
            } else {
                this.handType = HandType.PAIR;
            }
        } else {
            this.handType = HandType.HIGH_CARD;
        }
        
    }

    public HandType getHandType() {
        return this.handType;
    }

    public String getCards() {
        return this.cards;
    }

    public String getCard(int index) {
        return this.cards.substring(index, index + 1);
    }

    public int getBid() {
        return this.bid;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards='" + cards + '\'' +
                ", handType=" + handType +
                ", bid=" + bid +
                '}';
    }


}
