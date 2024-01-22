# sequence <= 1000000 입력으로 들어오기 때문에 시간복잡도 O(n)이하로 설계해야함.
# 투 포인터를 써서 시간복잡도 O(n)으로 설계해도 부분합을 구할 때 sum()을 쓰면 O(n)이므로 총 시간복잡도는 O(n^n)이 되므로 sum()을 쓰면 안됨.
# 따라서 sum_seq 변수를 두어 이 변수안에 합을 구하는 방식으로 구현해야 시간복잡도 O(n)으로 설계가 가능함.

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
