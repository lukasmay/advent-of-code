package org.y2023.day10;

public class Pipe {
    private int x;
    private int y;
    private int distance;
    private Direction[] pipeConnections;

    public Pipe(int x, int y, char type) {
        this.distance = 0;
        this.x = x;
        this.y = y;
        this.pipeConnections = new Direction[2];
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

    public Direction[] getPipeConnections() {
        return pipeConnections;
    }
}
