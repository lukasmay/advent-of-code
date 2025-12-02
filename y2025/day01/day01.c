#include <_stdio.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_LINE_LENGTH 4137

int part1() {
  FILE *file;
  char line[MAX_LINE_LENGTH];

  file = fopen("input.txt", "r");

  if (file == NULL) {
    perror("Error opening file");
    return EXIT_FAILURE;
  }
  int position = 50;
  int result = 0;

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    char dir = line[0];
    int size = atoi(line + 1);

    size = size % 100;

    if (dir == 'L') {
      position = position - size;
    } else {
      position = position + size;
    }
    // printf("Before Check: %d\n", position);

    if (position > 99) {
      position = position % 100;
    } else if (position < 0) {
      position = 100 - abs(position);
    }

    if (position == 0) {
      result++;
      // printf("Result update: %d\n", result);
    }
    // printf("%c%d: %d\n", dir, size, position);
  }
  printf("Part 1: %d\n", result);
  fclose(file);
  return 1;
}

int part2() {
  FILE *file;
  char line[MAX_LINE_LENGTH];

  file = fopen("input.txt", "r");

  if (file == NULL) {
    perror("Error opening file");
    return EXIT_FAILURE;
  }

  int position = 50;
  int result = 0;

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    char dir = line[0];
    int size = atoi(line + 1);

    for (int i = 0; i < size; i++) {
      if (dir == 'L') {
        position--;
        if (position < 0) {
          position = 99;
        }
      } else {
        position++;
        if (position > 99) {
          position = 0;
        }
      }

      if (position == 0) {
        result++;
      }
    }
  }
  printf("Part2: %d\n", result);
  fclose(file);
  return 1;
}

int main(int argc, char *argv[]) {
  part1();
  part2();
  return 1;
}
