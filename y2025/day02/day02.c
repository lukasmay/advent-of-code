#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

int part1(FILE *file) {
    char line[MAX_LINE_LENGTH];
    int result = 0;
    
    // Reset file pointer to beginning if needed
    fseek(file, 0, SEEK_SET);

    while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
        // Logic here
    }
    return result;
}

int part2(FILE *file) {
    char line[MAX_LINE_LENGTH];
    int result = 0;

    fseek(file, 0, SEEK_SET);

    while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
        // Logic here
    }
    return result;
}

int main() {
    FILE *file = fopen("input.txt", "r");
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    printf("Part 1: %d\n", part1(file));
    printf("Part 2: %d\n", part2(file));

    fclose(file);
    return EXIT_SUCCESS;
}
