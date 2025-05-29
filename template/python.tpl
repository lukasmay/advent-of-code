# Advent of Code - Day {{DAY}}

def part1(lines):
    return 0

def part2(lines):
    return 0

if __name__ == "__main__":
    with open("../resources/day{{DAY}}.txt") as f:
        raw = f.read().strip()

    # Try one of these depending on your puzzle structure:
    # lines = raw.splitlines()
    # blocks = list(map(str.splitlines, raw.split("\n\n")))
    # grid = [list(map(int, line)) for line in raw.splitlines()]
    # points = [list(map(int, p.split(","))) for p in raw.split(" -> ")]

    lines = raw.splitlines()
    print("Part 1:", part1(lines))
    print("Part 2:", part2(lines))
