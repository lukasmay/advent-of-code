#include <_stdio.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_LINE_LENGTH 256

int main(int argc, char *argv[]) {
  FILE *file;
  char line[MAX_LINE_LENGTH];

  file = fopen("input.txt", "r");

  if (file == NULL) {
    perror("Error opening file");
    return EXIT_FAILURE;
  }

  while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
  }

  fclose(file);

  return 1;
}
