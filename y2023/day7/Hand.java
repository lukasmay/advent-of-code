package org.y2023.day7;

import java.util.HashMap;
import java.util.Map;

public class Hand {
    private String cards;
    private HandType handType;
    private int bid;

    public Hand(String cards, int bid) {
        this.cards = cards;
        this.bid = bid;
        this.handType = HandType.HIGH_CARD;

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

        if (jCount == 5) {
            this.handType = HandType.FIVE_OF_A_KIND;
        }
        for (char card : handTypeCount.keySet()) { // Need to put checks for not downgrading the handType
            handTypeCount.put(card, handTypeCount.get(card) + jCount);

            if (handTypeCount.containsValue(5)) {
                betterHand(HandType.FIVE_OF_A_KIND);
            } else if (handTypeCount.containsValue(4)) {
                betterHand(HandType.FOUR_OF_A_KIND);
            } else if (handTypeCount.containsValue(3) && handTypeCount.containsValue(2)) {
                betterHand(HandType.FULL_HOUSE);
            } else if (handTypeCount.containsValue(3)) {
                betterHand(HandType.THREE_OF_A_KIND);
            } else if (handTypeCount.values().stream().filter(v -> v == 2).count() == 2) {
                betterHand(HandType.TWO_PAIR);
            } else if (handTypeCount.values().stream().filter(v -> v == 2).count() == 1) {
                betterHand(HandType.PAIR);
            } else {
                betterHand(HandType.HIGH_CARD);
            }

            handTypeCount.put(card, handTypeCount.get(card) - jCount);
        }
        
    }

    private void betterHand(HandType handType) {
        if (this.handType.getStrength() < handType.getStrength()) {
            this.handType = handType;
        }
    }

    public HandType getHandType() {
        return this.handType;
    }

    public String getCards() {
        return this.cards;
    }

    public char getCard(int index) {
        return this.cards.charAt(index);
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
