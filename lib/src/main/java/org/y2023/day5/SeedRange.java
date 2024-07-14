package org.y2023.day5;

import org.y2023.day5.Day5.Overlap;

public class SeedRange {
    private long min;
    private long max;

    public SeedRange(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public Overlap contains(long minChange, long maxChange) {
        if (minChange >= this.max || maxChange <= this.min) {
            return Overlap.NONE;
        } else if (minChange <= this.min && maxChange >= this.max) {
            return Overlap.FULL;
        } else {
            return Overlap.PARTIAL;
        }
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }
    
    public void setMinMax(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public void fullConversion(long conversion) {
        min += conversion;
        max += conversion;
    }

    @Override
    public String toString() {
        return "[Min: " + min + ", Max: " + max + "]";
    }
}
