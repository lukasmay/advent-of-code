package org.y2023.day3;

import java.util.List;

import com.google.common.base.Objects;

public class Part {
    int number;
    List<int[]> locations;

    Part(int number, List<int[]> locations) {
        this.number = number;
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Number: " + number + " Location: " + locations;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Part part = (Part) obj;
        return number == part.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}