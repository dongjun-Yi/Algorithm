import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i+1))

    time_sum = 0
    table_round_count = 0
    length = len(food_times)
    
    while time_sum + ((q[0][0] - table_round_count) * length) <= k:
        now = heapq.heappop(q)[0] 
        time_sum += (now - table_round_count) * length
        length -=1
        table_round_count = now
        
    answer = sorted(q, key = lambda x : x[1])
    return answer[(k-time_sum) % length][1]