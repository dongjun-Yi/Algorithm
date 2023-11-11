# 시간이 적게 걸리는 음식부터 확인하는 Greedy 접근 방식
import heapq

def solution(food_times, k):
    if sum(food_times) <=k:
        return -1
    
    q = []
    for i in range(len(food_times)):
        # 시간이 작은 음식부터 순서 나열
        heapq.heappush(q, (food_times[i], i+1))

    sum_value = 0 # 먹기 위해 사용한 시간
    previous = 0 # 직전에 다 먹은 음식 시간
    
    # 남은 음식의 개수
    length = len(food_times)
    
    # q[0][0] - previous : previous는 회전한 횟수, 이 회전횟수를 남은 음식 중 소요시간이 짧은 음식 시간에서 뺴줌
    
    while sum_value + ((q[0][0] - previous) *length) <=k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous) * length
        # 다먹은 음식처리
        length-=1
        previous = now
    
    # 남은 음식 중에서 몇번째 음식인지 확인
    result = sorted(q, key = lambda x : x[1]) # 음식의 번호 기준으로 정렬
    idx = result[(k-sum_value) % length] [1]
    return idx