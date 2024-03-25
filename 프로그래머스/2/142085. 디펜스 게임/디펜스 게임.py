import heapq

def solution(n, k, enemy):
    answer, sum_value = 0, 0
    q = []
    
    for e in enemy:
        heapq.heappush(q, -e) # 최소힙이므로 음수 삽입
        sum_value += e
        
        if sum_value > n: # 디펜스 못할때
            
            if k == 0:
                break
            sum_value += heapq.heappop(q) # 무적권 사용으로 해당 라운드 인원수 복구
            k-=1
        answer += 1
        
    return answer