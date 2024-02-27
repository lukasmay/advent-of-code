file = open('Data.txt','r')
solution = 0
for line in file:
	if (line.rfind('\n') == -1):
		line = line
	else:
		line = line[0:(line.rfind('\n'))]
	elf1 = line[0:line.rfind(',')]
	elf2 = line[(line.rfind(',')+1):len(line)]
	elf1start = elf1[0:elf1.rfind('-')]
	elf1end = elf1[(elf1.rfind('-')+1):len(elf1)]
	elf2start = elf2[0:elf2.rfind('-')]
	elf2end = elf2[(elf2.rfind('-')+1):len(elf2)]
	elf1start = int(elf1start)
	elf2start = int(elf2start)
	elf1end = int(elf1end)
	elf2end = int(elf2end)
	if ((elf1start >= elf2start and elf1start <= elf2end) or (elf2start >= elf1start and elf2start <= elf1end) or (elf1end >= elf2start and elf1end <= elf2end) or (elf2end >= elf1start and elf2end <= elf1end)):
		solution += 1
print(solution)



file = open('Data.txt','r')

solution = 0
i = 0
print("start")
for line in file:
	if (line.rfind('\n') == -1):
		line = line
	else:
		line = line[0:(line.rfind('\n'))]
	elf1 = line[0:line.rfind(',')]
	elf2 = line[(line.rfind(',')+1):len(line)]
	elf1start = elf1[0:elf1.rfind('-')]
	elf1end = elf1[(elf1.rfind('-')+1):len(elf1)]
	elf2start = elf2[0:elf2.rfind('-')]
	elf2end = elf2[(elf2.rfind('-')+1):len(elf2)]
	elf1start = int(elf1start)
	elf2start = int(elf2start)
	elf1end = int(elf1end)
	elf2end = int(elf2end)
	
	
	i += 1

	if ((elf1start > elf2start and elf1end < elf2end) or (elf1start < elf2start and elf1end > elf2end) or (elf1end == elf2end) or (elf1start == elf2start)):
		solution += 1
	
print(solution)
