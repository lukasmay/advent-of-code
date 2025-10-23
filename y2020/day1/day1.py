
def print_entries(entries):
    for i in entries:
        print(i)


def main():
    file = open('/Users/lukasmay/git/advent-of-code/y2020/day1/input_day1.txt','r')

    entries = []

    for line in file:
        entries.append(int(line.strip()))

    for e in entries:
        for i in entries:
            for a in entries:
                if (e + i + a) == 2020:
                    print(f"{e} + {i} + {a}")
                    print(e * i * a)
                    return

                

if __name__ == "__main__":
    main()