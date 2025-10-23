
file = open('/Users/lukasmay/git/advent-of-code/y2024/day1/input_day1.txt', 'r')

row = []

for line in file:
    row.append(line.strip().split("   "))

left = []
right = []

for thing in row:
    left.append(int(thing[0]))
    right.append(int(thing[1]))

left.sort()
right.sort()


distance = 0
for i in range(len(left)):
    operation = abs(left[i] - right[i])
    #print(operation)
    distance += operation
    
print(distance)