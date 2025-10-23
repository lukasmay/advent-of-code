
file = open('/Users/lukasmay/git/advent-of-code/y2024/day1/input_day1.txt', 'r')

row = []

for line in file:
    row.append(line.strip().split("   "))

left = []
right = []

for thing in row:
    left.append(int(thing[0]))
    right.append(int(thing[1]))


similar = 0
appear = []
for i in left:
    for r in right:
        if(i == r):
            similar += 1
    multi = similar * i
    similar = 0
    appear.append(multi)

result = 0
for e in appear:
    result += e

print(result)

    
