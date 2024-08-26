package org.y2023.day10;

public class Pipe {
    private char pipeSymbol;
    private int x;
    private int y;
    private int distance;
    private Direction[] pipeDirections;

    public Pipe(int x, int y, char type) {
        this.pipeSymbol = type;
        this.distance = 0;
        this.x = x;
        this.y = y;
        this.pipeDirections = Pipes.fromChar(type);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    public char getPipeSymbol() {
        return pipeSymbol;
    }

    public Direction[] getPipDirections() {
        return pipeDirections;
    }

    @Override
    public String toString() {
        return Character.toString(this.pipeSymbol);
    }
}
