def count_up(base, step=1, count=10, start=0):
    result = []
    for i in range(count):
        num = start + i*step
        digits = []
        while num:
            digits.append(int(num % base))
            num = num // base
        result.append(''.join(map(str, digits[::-1])))
    return result



def findModeCount(num, base, start):
    result_num = count_up(base, count=num, start=int(start, base))
    digit_count = []
    for i in result_num:
        for j in i:
            digit_count.append(j)
    most_common = max(set(digit_count), key=digit_count.count)
    answer = 0
    for i in digit_count:
        if i == most_common:
            answer += 1
    return answer





print(findModeCount(25,2,1111011))
