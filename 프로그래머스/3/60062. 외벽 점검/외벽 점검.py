from itertools import permutations

def solution(n, weak, dist):
    answer = len(dist) + 1
    length = len(weak)
    
    for i in range(length):
        weak.append(weak[i] + n)
        
    for start in range(length):
        for friends in list(permutations(dist, len(dist))):
            count = 1
            last = weak[start] + friends[count - 1] # 친구의 최대 탐색 지점
            for index in range(start, start + length): # 한바퀴
                if last < weak[index]:
                    count += 1
                    if count > len(dist):
                        break
                    last = weak[index] + friends[count - 1] # 친구의 최대 탐색 지점 초과 시 다른 친구 투입
            answer = min(answer, count)
            
    if answer > len(dist):
        return -1
            
    return answer