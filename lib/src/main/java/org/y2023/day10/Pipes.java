package org.y2023.day10;

public enum Pipes {
    V('|'), H('-'), NE('L'), NW('J'), SE('F'), SW('7'), START('S'), GROUND('.');

    private char pipe;

    Pipes(char pipe) {
        this.pipe = pipe;
    }
}
