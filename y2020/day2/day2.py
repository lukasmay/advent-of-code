def pstuff(thing):
    for i in thing:
        print(f"Line: {i}")
            
file = open('/Users/lukasmay/git/advent-of-code/y2020/day2/input_day2.txt', 'r')

result = []

for line in file:
    current = line.strip().split(" ")

    counter = 0
    pos1 = int(current[0].split("-")[0]) - 1
    pos2 = int(current[0].split("-")[1]) - 1
    letter = current[1][0]
    password = current[2]
    if ((password[pos1] == letter) ^ (password[pos2] == letter)):
        result.append(password)



print(len(result))

    
