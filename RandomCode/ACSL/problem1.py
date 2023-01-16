def count_up(num, base):
    digits = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    num = int(num, base)
    num += 1
    result = ''
    while num > 0:
        result = digits[num % base] + result
        num = num // base
    return result


def findModeCount(num, base, start):
    start = str(start)
    result_num = []
    result_num.append(start)
    for i in range(num-1):
        result_num.append(count_up(start, base))
        start = result_num[i+1]
    digit_count = []
    count = 1
    for i in result_num:
        #print(str(count) + ": " + i)
        #print(i)
        count += 1
        for j in i:
            digit_count.append(j)
    most_common = max(set(digit_count), key=digit_count.count)
    answer = 0
    #print(most_common)
    for i in digit_count:
        if i == most_common:
            answer += 1
    return answer


print(findModeCount(10,16,'ABCDEF'))
