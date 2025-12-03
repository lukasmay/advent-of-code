#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/_types/_u_int64_t.h>

#define MAX_LINE_LENGTH 1024

int part1(FILE *file) {
  char line[MAX_LINE_LENGTH];
  int result = 0;
  fseek(file, 0, SEEK_SET);

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    int current = 0;
    char temp[3];
    temp[2] = '\0';
    for (int i = 0; i < strlen(line); i++) {
      for (int l = i + 1; l < strlen(line); l++) {
        temp[0] = line[i];
        temp[1] = line[l];
        int value = atoi(temp);
        if (value > current) {
          current = value;
        }
      }
    }
    result += current;
  }
  return result;
}

u_int64_t part2(FILE *file) {
  char line[MAX_LINE_LENGTH];
  u_int64_t result = 0;
  fseek(file, 0, SEEK_SET);
  int size = 12;
  char temp[13];
  temp[12] = '\0';

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    char value[13];
    value[12] = '\0';
    int start_offset = 0;
    for (int digit = 0; digit < size; digit++) {
      int farthest = size - digit;
      int current = 0;

      for (int i = start_offset; i < strlen(line) - farthest; i++) {
        int tmp = line[i] - '0';
        if (tmp > current) {
          value[digit] = line[i];
          current = tmp;
          start_offset = i + 1;
        }
      }
    }
    result += strtoull(value, NULL, 10);
  }
  return result;
}

int main(int argc, char *argv[]) {
  const char *filename = (argc > 1) ? argv[1] : "test.txt";
  FILE *file = fopen(filename, "r");

  if (file == NULL) {
    perror("Error opening file");
    return EXIT_FAILURE;
  }

  // printf("Part 1: %d\n", part1(file));
  printf("Part 2: %llu\n", part2(file));

  fclose(file);
  return EXIT_SUCCESS;
}
