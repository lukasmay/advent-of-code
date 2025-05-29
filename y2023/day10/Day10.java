package org.y2023.day10;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Start pipe is L at 76, 109
public class Day10 {

    public static void main(String[] args) {
        try {
            String input = "lib/src/main/java/org/y2023/resources/day10.txt";
            System.out.println("Part1: " + part1(input));
            // System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int part1(String input) throws IOException {
        String line = "";
        List<char[]> grid = new ArrayList<>();
        Scanner scanner = new Scanner(new File(input));

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            grid.add(line.toCharArray());

        }
        scanner.close();
        Pipe[][] pipes = new Pipe[grid.size()][grid.get(0).length];

        int[] startPos = new int[2];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length; j++) {
                if (grid.get(i)[j] == 'S') {
                    startPos[0] = i;
                    startPos[1] = j;
                    pipes[i][j] = new Pipe(i, j, 'F');// Replace this with start
                } else {
                    pipes[i][j] = new Pipe(i, j, grid.get(i)[j]);
                }
            }
        }

        List<Pipe> path = new ArrayList<>();
        int[] lastPos = {0, 0};
        int[] currentPos = startPos;

        for (Pipe[] row : pipes) {
            for (Pipe item : row) {
                System.out.print(item);
            }
            System.out.println();
        }
        

        do {
            Pipe currentPipe = pipes[currentPos[0]][currentPos[1]];
            path.add(currentPipe);
            Direction[] directions = currentPipe.getPipDirections();
            
            for (Direction d : directions) {
                if (d.getX() + currentPipe.getX() != lastPos[0] && d.getY() + currentPipe.getY() != lastPos[1]) {
                    System.out.print(d);
                    System.out.println(" " + currentPipe);
                    Pipe nextPipe = pipes[d.getX() + currentPipe.getX()][d.getY() + currentPipe.getY()];
                    path.add(nextPipe);
                    lastPos = currentPos;
                    currentPos = new int[] {d.getX() + currentPipe.getX(), d.getY() + currentPipe.getY()};
                }
            }
            System.out.println(currentPipe);
        } while (currentPos != startPos);

        for (Pipe[] p : pipes) {
            for (Pipe a : p) {
                System.out.println(a + " ");
            }
        }
        
        return 0;
    }

    public static void printGrid(Pipe[][] pipes) {
        for (Pipe[] p : pipes) {
            for (Pipe pipe : p) {
                System.out.print(pipe.getPipeSymbol());
            }
            System.out.println();
        }
    }

    public static int part2(String input) throws IOException {
        String line = "";
        Scanner scanner = new Scanner(new File(input));
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

        }
        scanner.close();
        return 0;
    }
}