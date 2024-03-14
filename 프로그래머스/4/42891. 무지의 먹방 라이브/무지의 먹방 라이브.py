import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    length = len(food_times)
    q = []
    for i in range(length):
        heapq.heappush(q, (food_times[i], i + 1))
        
    round = 0
    s = 0
    
    while s + ((q[0][0] - round) * length) <= k:
        now = heapq.heappop(q)[0]
        s += (now - round) * length
        length -=1
        round = now

    answer = sorted(q, key = lambda x: x[1])
    return answer[(k-s)%length][1]