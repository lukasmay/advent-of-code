package org.y2023.day10;

public enum Pipes {
    V('|'), H('-'), NE('L'), NW('J'), SE('F'), SW('7'), START('S'), GROUND('.');

    private char pipe;

    Pipes(char pipe) {
        this.pipe = pipe;
    }

    public char getPipe() {
        return pipe;
    }

    public static Direction[] fromChar(char c) {
        switch (c) {
            case '|':
                return new Direction[] { Direction.NORTH, Direction.SOUTH };
            case '-':
                return new Direction[] { Direction.EAST, Direction.WEST };
            case 'L':
                return new Direction[] { Direction.NORTH, Direction.EAST };
            case 'J':
                return new Direction[] { Direction.NORTH, Direction.EAST };
            case 'F':
                return new Direction[] { Direction.SOUTH, Direction.EAST };
            case '7':
                return new Direction[] { Direction.SOUTH, Direction.WEST };
            case 'S':
                return new Direction[] { Direction.NORTH, Direction.SOUTH };
            case '.':
                return new Direction[] {};
            default:
                return new Direction[] {};
        }
    }

    public static Direction[] fromPipes(Pipes p) {
        return fromChar(p.pipe);
    }
}
