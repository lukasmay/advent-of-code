file = open('input.txt','r')
result = ['']
score = 0
NUM = 31
i = 0 
a = 0
elf = ["", "", ""]



for line in file:
	stop = False
	if (line.rfind('\n') == -1):
		line = line
	else:
		line = line[0:(line.rfind('\n'))]
	if (i == 3):
		i = 1
		#print(elf)
		for pack in elf[0]:
			
			if (elf[1].__contains__(pack) and elf[2].__contains__(pack)):
				result.append(pack)
				stop = True
			if (stop):
				stop = False
				break
		elf[0] = line
		
	else:
		elf[i] = line
		i += 1
for pack in elf[0]:
	if (elf[1].__contains__(pack) and elf[2].__contains__(pack)):
		result.append(pack)
		stop = True
	if (stop):
		stop = False
		break

del result[0]
for letter in result:
	if (letter.isupper()):
		#print(letter)
		#print((ord(letter) & NUM) + 26)
		score += (ord(letter) & NUM) + 26
	else:
		#print(letter)
		#print((ord(letter) & NUM))
		score += (ord(letter) & NUM)
print(score)

file = open('input.txt','r')
result = ['']
score = 0
NUM = 31
i = 0 

for line in file:
	stop = False
	i += 1
	if (line.rfind('\n') == -1):
		line = line
	else:
		line = line[0:(line.rfind('\n'))]
	midindex  = int(len(line)/2)
	sack1 = line[0:midindex]
	sack2 = line[midindex:len(line)]
	test = sack1
	test += sack2
	for item1 in sack1:
		for item2 in sack2:
			if(item1 == item2):
				result.append(item1)
				stop = True
				print(i)
				print(line)
				print(sack1)
				print(sack2)
				print(item1)
			if (stop):
				break
		if (stop):
			break

del result[0]
for letter in result:
	if (letter.isupper()):
		#print(letter)
		#print((ord(letter) & NUM) + 26)
		score += (ord(letter) & NUM) + 26
	else:
		#print(letter)
		#print((ord(letter) & NUM))
		score += (ord(letter) & NUM)
print(score)
