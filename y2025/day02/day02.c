#include <ctype.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 4096
#define MAX_ID_LENGTH 64

typedef uint64_t (*id_checker_t)(uint64_t);

uint64_t check_id_part1(uint64_t id) {
  char check[MAX_ID_LENGTH];
  snprintf(check, sizeof(check), "%llu", id);

  int length = strlen(check);

  if (length % 2 != 0) {
    return 0;
  }

  int half = length / 2;
  char first_half[half + 1];
  char second_half[half + 1];

  strncpy(first_half, check, half);
  first_half[half] = '\0';

  strncpy(second_half, check + half, half);
  second_half[half] = '\0';

  if (strcmp(first_half, second_half) == 0) {
    return id;
  }

  return 0;
}

uint64_t check_id_part2(uint64_t id) {
  char s[MAX_ID_LENGTH];
  snprintf(s, sizeof(s), "%llu", id);
  int len = strlen(s);

  for (int p_len = 1; p_len <= len / 2; p_len++) {
    if (len % p_len != 0) {
      continue;
    }

    int is_pattern = 1;
    for (int i = p_len; i < len; i++) {
      if (s[i] != s[i - p_len]) {
        is_pattern = 0;
        break;
      }
    }

    if (is_pattern) {
      return id;
    }
  }

  return 0;
}

uint64_t check_range(uint64_t start, uint64_t end, id_checker_t checker) {
  uint64_t sum = 0;
  for (uint64_t i = start; i <= end; i++) {
    sum += checker(i);
  }
  return sum;
}

uint64_t solve(FILE *file, id_checker_t checker) {
  char line[MAX_LINE_LENGTH];
  fseek(file, 0, SEEK_SET);

  uint64_t result = 0;

  int offset = 0;
  int parsing_start = 1;
  char start_buf[MAX_ID_LENGTH] = {0};
  char end_buf[MAX_ID_LENGTH] = {0};

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
    int length = strlen(line);

    for (int i = 0; i < length; i++) {
      char c = line[i];

      if (c == ',' || c == '\n') {
        if (offset > 0) {
          uint64_t s_val = strtoull(start_buf, NULL, 10);
          uint64_t e_val = strtoull(end_buf, NULL, 10);
          result += check_range(s_val, e_val, checker);
        }

        parsing_start = 1;
        offset = 0;
        memset(start_buf, 0, sizeof(start_buf));
        memset(end_buf, 0, sizeof(end_buf));

      } else if (c == '-') {
        parsing_start = 0;
        offset = 0;
      } else if (isdigit(c)) {
        if (parsing_start) {
          if (offset < MAX_ID_LENGTH - 1)
            start_buf[offset++] = c;
        } else {
          if (offset < MAX_ID_LENGTH - 1)
            end_buf[offset++] = c;
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

  printf("Part 1: %llu\n", solve(file, check_id_part1));
  printf("Part 2: %llu\n", solve(file, check_id_part2));

  fclose(file);
  return EXIT_SUCCESS;
}
