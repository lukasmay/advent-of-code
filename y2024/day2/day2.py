

def part1():
    file = open("/Users/lukasmay/git/advent-of-code/y2024/day2/input_day2.txt")

    result = 0

    for line in file:
        report = [int(c) for c in line.strip().split(" ")]
        inc = False
        dec = False


        for i in range(0, len(report)-1):
            diff = report[i] - report[i+1]
            if (diff == 0):
                inc = False
                dec = False
                break
            elif (abs(diff) > 3):
                inc = False
                dec = False
                break
            elif (diff > 0):
                dec = True
                if (inc):
                    break
            else:
                inc = True
                if (dec):
                    break

        if (inc ^ dec):
            result += 1
    return result


def part2():
    file = open("/Users/lukasmay/git/advent-of-code/y2024/day2/input_day2.txt")

    result = 0

    for line in file:
        report = [int(c) for c in line.strip().split(" ")]
        inc = False
        dec = False
        mistake = 0
        valid = True


        for i in range(0, len(report)-1):
            diff = report[i] - report[i+1]
            if (diff == 0):
                mistake += 1
            elif (abs(diff) > 3):
                mistake += 1
            elif (diff > 0):
                dec = True
                if (inc):
                    mistake += 1
            else:
                inc = True
                if (dec):
                    mistake += 1

            if mistake > 1:
                valid = False
                break

        if (valid):
            result += 1
    return result




def main():
    # print(part1())
    print(part2())






if __name__ == "__main__":
    main()

