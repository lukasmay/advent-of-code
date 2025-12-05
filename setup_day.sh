#!/bin/bash

# Default values
YEAR=$(date +%Y)
DAY=$(date +%d)
LANG_EXT=""
LANGUAGE=""

# Function to display usage
usage() {
    echo "Usage: $0 <language> [-y|--year <year>] [-d|--day <day>]"
    echo "Languages: python, java, c"
    echo "Example: $0 python -y 2024 -d 05"
    exit 1
}

# Parse arguments
# We loop through arguments to handle both flags and the positional language argument
while [[ $# -gt 0 ]]; do
    key="$1"
    case $key in
        -y|--year)
            YEAR="$2"
            shift # past argument
            shift # past value
            ;;
        -d|--day)
            DAY="$2"
            shift # past argument
            shift # past value
            ;;
        python|java|c)
            LANGUAGE="$1"
            shift # past argument
            ;;
        *)
            echo "Error: Unknown argument or language '$1'"
            usage
            ;;
    esac
done

# Check if language was provided
if [ -z "$LANGUAGE" ]; then
    echo "Error: Language argument (python, java, c) is required."
    usage
fi

# Define Directory Paths
YEAR_DIR="y$YEAR"
DAY_DIR="$YEAR_DIR/day$DAY"

# Check if directory already exists
if [ -d "$DAY_DIR" ]; then
    echo "Warning: Directory $DAY_DIR already exists."
    echo "Directory Contents:"
    ls $DAY_DIR
    echo
    read -p "Do you want to continue and potentially overwrite files? (y/n) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        echo "Aborted."
        exit 1
    fi
fi

# Create Directories
echo "Creating directory: $DAY_DIR"
mkdir -p "$DAY_DIR"

# Create Input Files
touch "$DAY_DIR/input.txt"
touch "$DAY_DIR/test.txt"
echo "Created input.txt and test.txt"

# Generate Code Files based on Language
case $LANGUAGE in
    python)
        FILENAME="day$DAY.py"
        FILEPATH="$DAY_DIR/$FILENAME"
        cat <<EOF > "$FILEPATH"
import sys

def part1(data):
    return 0

def part2(data):
    return 0

def main():
    try:
        with open("input.txt", "r") as f:
            data = f.read().splitlines()
    except FileNotFoundError:
        print("Error: input.txt not found")
        return

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")

if __name__ == "__main__":
    main()
EOF
        ;;

    c)
        FILENAME="day$DAY.c"
        FILEPATH="$DAY_DIR/$FILENAME"
        cat <<EOF > "$FILEPATH"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

int part1(FILE *file) {
    char line[MAX_LINE_LENGTH];
    int result = 0;
    fseek(file, 0, SEEK_SET);

    while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    }
    return result;
}

int part2(FILE *file) {
    char line[MAX_LINE_LENGTH];
    int result = 0;
    fseek(file, 0, SEEK_SET);

    while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    }
    return result;
}

int main(int argc, char *argv[]) {
    FILE *file = fopen(filename, "r");
    const char *filename = (argc > 1) ? argv[1] : "test.txt";

    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    printf("Part 1: %d\n", part1(file));
    printf("Part 2: %d\n", part2(file));

    fclose(file);
    return EXIT_SUCCESS;
}
EOF
        ;;

    java)
        FILENAME="day$DAY.java"
        FILEPATH="$DAY_DIR/$FILENAME"
        CLASS_NAME="day$DAY"
        cat <<EOF > "$FILEPATH"
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class $CLASS_NAME {

    public static void main(String[] args) {
        List<String> input = readInput("input.txt");
        System.out.println("Part 1: " + part1(input));
        System.out.println("Part 2: " + part2(input));
    }

    public static int part1(List<String> input) {
        return 0;
    }

    public static int part2(List<String> input) {
        return 0;
    }

    private static List<String> readInput(String filename) {
        List<String> lines = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }
}
EOF
        ;;
esac

echo "Created starter code: $FILEPATH"
echo "Done! Good luck with Day $DAY!"
echo "cd $DAY_DIR"
