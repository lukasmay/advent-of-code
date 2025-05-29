import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Day{{DAY}} {

    public static void main(String[] args) {
        try {
            String input = "../resources/day{{DAY}}.txt";
            System.out.println("Part1: " + part1(input));
            System.out.println("Part2: " + part2(input));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int part1(String input) throws IOException {
        String line = "";
        Scanner scanner = new Scanner(new File(input));
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // Process line here
        }
        scanner.close();
        return 0;
    }

    public static int part2(String input) throws IOException {
        String line = "";
        Scanner scanner = new Scanner(new File(input));
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            // Process line here
        }
        scanner.close();
        return 0;
    }
}
