package org.y2023.day7;

public enum HandType {
    FIVE_OF_A_KIND(7),
    FOUR_OF_A_KIND(6),
    FULL_HOUSE(5),
    THREE_OF_A_KIND(4),
    TWO_PAIR(3),
    PAIR(2),
    HIGH_CARD(1);

    private final int strength;

    HandType(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}