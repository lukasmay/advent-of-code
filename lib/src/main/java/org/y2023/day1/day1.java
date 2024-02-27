package org.y2023.day1;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Day1 {
    private static final Map<String, String> CONVERT = new HashMap<String, String>() {{
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
        put("zero", "0");
        put("1", "1");
        put("2", "2");
        put("3", "3");
        put("4", "4");
        put("5", "5");
        put("6", "6");
        put("7", "7");
        put("8", "8");
        put("9", "9");
        put("0", "0");
    }};

    private static final List<String> words = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

    public static void main(String[] args) throws IOException {
        String input_file = "lib/src/main/resources/y2023/day1.txt";
        System.out.println(part1(input_file));
        System.out.println(part2(input_file));
    }

    public static int part1(String input_file) throws IOException {
        int sum = 0;
        BufferedReader reader = new BufferedReader(new FileReader(input_file));
        String line;
        while ((line = reader.readLine()) != null) {
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(line);
            List<String> matches = new ArrayList<>();
            while (matcher.find()) {
                matches.add(matcher.group());
            }
            sum += Integer.parseInt(matches.get(0) + matches.get(matches.size() - 1));
        }
        reader.close();
        return sum;
    }

    public static int part2(String input_file) throws IOException {
        int sum = 0;
        BufferedReader reader = new BufferedReader(new FileReader(input_file));
        String line;
        while ((line = reader.readLine()) != null) {
            List<Pair<Integer, String>> indexes = new ArrayList<>();
            for (String word : words) {
                Pattern pattern = Pattern.compile(word);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    indexes.add(new Pair<>(matcher.start(), word));
                }
            }
            indexes.sort(Comparator.comparing(Pair::getKey));
            sum += Integer.parseInt(CONVERT.get(indexes.get(0).getValue()) + CONVERT.get(indexes.get(indexes.size() - 1).getValue()));
        }
        reader.close();
        return sum;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}