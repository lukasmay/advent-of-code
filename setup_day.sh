#!/usr/bin/env bash

# Default values
YEAR=$(date +%Y)
LANG="java"

# Parse command-line flags
while getopts "d:y:l:" opt; do
  case $opt in
    d) DAY="$OPTARG" ;;
    y) YEAR="$OPTARG" ;;
    l) LANG="$OPTARG" ;;
    \?) echo "Usage: $0 -d <day> [-y <year>] [-l <language>]"; exit 1 ;;
  esac
done

# Validate required input
if [ -z "$DAY" ]; then
  echo "Error: Day (-d) is required"
  echo "Usage: $0 -d <day> [-y <year>] [-l <language>]"
  exit 1
fi

# Zero-pad day
DAY_PADDED=$(printf "%02d" $DAY)

# File extension based on language
case "$LANG" in
  java) EXT="java" ;;
  python) EXT="py" ;;
  c) EXT="c" ;;
  *) echo "Unsupported language: $LANG"; exit 1 ;;
esac

# Paths
DAY_DIR="$YEAR/day$DAY_PADDED"
RES_DIR="$YEAR/resources"
SRC_FILE="$DAY_DIR/day$DAY_PADDED.$EXT"
RES_FILE="$RES_DIR/day$DAY_PADDED.txt"
TEMPLATE="templates/$LANG.tpl"

# Create directories
mkdir -p "$DAY_DIR"
mkdir -p "$RES_DIR"

# Create source file from template
if [ -f "$TEMPLATE" ]; then
  sed "s/{{DAY}}/$DAY_PADDED/g" "$TEMPLATE" > "$SRC_FILE"
  echo "Created source file: $SRC_FILE"
else
  echo "Template not found: $TEMPLATE"
  exit 1
fi

# Create input file
touch "$RES_FILE"
echo "Created input file: $RES_FILE"

