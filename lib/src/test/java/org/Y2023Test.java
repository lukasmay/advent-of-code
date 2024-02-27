package org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.y2023.day1.Day1;
import org.y2023.day2.Day2;

public class Y2023Test {
    @Test
    public void day1() {
        try {
            assertEquals(54927, Day1.part1("lib/src/main/resources/y2023/day1.txt"));
            assertEquals(54581, Day1.part2("lib/src/main/resources/y2023/day1.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void day2() {
        try {
            assertEquals(2348, Day2.part1("lib/src/main/resources/y2023/day2.txt"));
            assertEquals(76008, Day2.part2("lib/src/main/resources/y2023/day2.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
