def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(key=lambda x : (x[col-1], -x[0]))
    s = []

    for i in range(row_begin-1, row_end):
        tmp = 0
        for j in range(len(data[i])):
            tmp += data[i][j] % (i + 1)
        s.append(tmp)

    answer = 0
    
    for x in s:
        answer ^=  x

    return answer