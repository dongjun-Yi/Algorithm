def solution(sequence, k):
    result = [0, len(sequence)]
    lt,rt = 0, 0
    sum_seq = sequence[0]
    
    while True:
        if sum_seq < k:
            rt +=1
            if rt == len(sequence):
                break
            sum_seq += sequence[rt]
        else:
            if sum_seq == k:
                if rt -lt < result[1] - result[0]:
                    result[0], result[1] = lt, rt
            sum_seq -= sequence[lt]
            lt +=1
    return result