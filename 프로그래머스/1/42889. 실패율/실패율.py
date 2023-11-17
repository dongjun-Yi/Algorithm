def solution(N, stages):
    answer = []
    # 스테이지 길이
    total= len(stages)
    for i in range(1,N+1):
        # 각 스테이지 실패인원 count
        cnt = stages.count(i)
        try:
            tmp = cnt/total
            answer.append((i,tmp))
        except ZeroDivisionError:
            answer.append((i, cnt))
        total-= cnt
    # 실패율(x[1])을 기준으로 내림차순 정렬하고, 만약 실패율이 같을 경우 번호순으로 정렬(-x[0])
    answer.sort(reverse=True, key = lambda x : (x[1], -x[0]))
    
    result = []
    for i, fail in answer:
        result.append(i)
    return result