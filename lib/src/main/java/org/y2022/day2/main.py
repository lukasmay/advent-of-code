#rock = 1
#paper = 2
#siz = 3
#win = 6
#draw = 3
score = 0
result = 0
bonus = 0
#A rock, B Paper, C Sizzor them
#X lose, Y draw, Z win me 



file = open('input.txt','r')
for round in file:
	round = round[0:3]
	if ("X" in round):
		if ("A" in round):
			bonus = 3
		elif ("B" in round):
			bonus = 1
		elif ("C" in round):
			result = 2
	elif ("Y" in round):
		result = 3
		if ("A" in round):
			bonus = 1
		elif ("B" in round):
			bonus = 2
		elif ("C" in round):
			bonus = 3
	elif ("Z" in round):
		result = 6
		if ("A" in round):
			bonus = 2
		elif ("B" in round):
			bonus = 3
		elif ("C" in round):
			bonus = 1
	score += bonus + result
	bonus = 0
	result = 0
	
print(score)
