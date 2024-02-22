from itertools import permutations

def solution(n, weak, dist):
    length = len(weak)
    for i in range(length): # 선형으로 변환
        weak.append(weak[i] + n)
        
    answer = len(dist) + 1 # 투입할 수 있는 최대 인원 + 1로 초기화
    
    for start in range(length):
        for friends in list(permutations(dist, len(dist))):
            count = 1
            position = weak[start] + friends[count - 1] # 한 친구가 외벽 점검을 할 수 있는 범위
            for index in range(start, start + length): # 시작 지점부터 원 한바퀴(선형으로 변환해서 start + length) 
                if position < weak[index]: # 한 친구가 점검할 수 있는 범위 초과
                    count += 1 
                    if count > len(dist):
                        break
                    position = weak[index] + friends[count - 1] # 해당 지점에서 새로운 친구 투입
            answer = min(answer, count) # 친구 인원 최소값 갱신
    if answer > len(dist):
        return -1
    return answer