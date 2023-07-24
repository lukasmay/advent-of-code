file = open('/Users/lukasmay/Documents/Github/AdventOfCode/2022/Day1/input.txt','r')
mostCalories = [0]
currentElf = 0
for line in file:
	if (line == "\n"):
		mostCalories.append(currentElf)
		currentElf = 0
	else:
		currentElf += int(line)
mostCalories.sort(reverse=True)
print(mostCalories[0] + mostCalories[1] + mostCalories[2])
