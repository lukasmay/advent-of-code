#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024
#define MAX_ROW 137
#define MAX_COLUMN 137

int check_around(int x, int y, char wall[MAX_ROW + 2][MAX_COLUMN + 2]) {
  int total = -1;
  for (int i = -1; i < 2; i++) {
    for (int l = -1; l < 2; l++) {
      if (wall[x + i][y + l] == '@') {
        total++;
      }
    }
  }
  return total;
}

int part1(FILE *file) {
  char line[MAX_LINE_LENGTH];
  int result = 0;
  fseek(file, 0, SEEK_SET);

  char wall[MAX_ROW + 2][MAX_COLUMN + 2];

  memset(wall, '.', sizeof(wall));

  int rows_read = 1;
  int width = 0;

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    line[strcspn(line, "\n")] = 0;

    size_t line_len = strlen(line);
    if (width == 0)
      width = (int)line_len;

    if (rows_read <= MAX_ROW) {
      memcpy(wall[rows_read] + 1, line, line_len);
      rows_read++;
    }
  }

  for (int i = 1; i < rows_read; i++) {
    for (int l = 1; l < width + 1; l++) {
      if (wall[i][l] == '@') {
        int next_to = check_around(i, l, wall);
        if (next_to < 4) {
          result++;
        }
      }
    }
  }

  return result;
}

int part2(FILE *file) {
  char line[MAX_LINE_LENGTH];
  int result = 0;
  fseek(file, 0, SEEK_SET);

  char wall[MAX_ROW + 2][MAX_COLUMN + 2];

  memset(wall, '.', sizeof(wall));

  int rows_read = 1;
  int width = 0;

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    line[strcspn(line, "\n")] = 0;

    size_t line_len = strlen(line);
    if (width == 0)
      width = (int)line_len;

    if (rows_read <= MAX_ROW) {
      memcpy(wall[rows_read] + 1, line, line_len);
      rows_read++;
    }
  }

  int amount = 0;
  while (amount == 0) {
    amount = 1;
    for (int i = 1; i < rows_read; i++) {
      for (int l = 1; l < width + 1; l++) {
        if (wall[i][l] == '@') {
          int next_to = check_around(i, l, wall);
          if (next_to < 4) {
            wall[i][l] = '.';
            amount = 0;
            result++;
          }
        }
      }
    }
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

  printf("Part 1: %d\n", part1(file));
  printf("Part 2: %d\n", part2(file));

  fclose(file);
  return EXIT_SUCCESS;
}
