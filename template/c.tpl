// Advent of Code - Day {{DAY}}

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LEN 256

int part1(FILE *fp) {
    char line[MAX_LINE_LEN];
    while (fgets(line, sizeof(line), fp)) {
        // Process line here
    }
    rewind(fp);
    return 0;
}

int part2(FILE *fp) {
    char line[MAX_LINE_LEN];
    while (fgets(line, sizeof(line), fp)) {
        // Process line here
    }
    return 0;
}

int main() {
    FILE *fp = fopen("../resources/day{{DAY}}.txt", "r");
    if (!fp) {
        perror("Failed to open input file");
        return 1;
    }

    printf("Part 1: %d\n", part1(fp));
    printf("Part 2: %d\n", part2(fp));

    fclose(fp);
    return 0;
}
