# truck_weights <= 10,000, bridge_length <=10,000이므로 시간 복잡도 O(n)이하로 설계해야함.
# sum()은 시간복잡도가 O(n)이므로 sum(bridge)로 구현했을 경우 O(n^2)이 되어서 O(10,000 * 10,000)이 되므로 시간초과 발생.
# 따라서 curren_weight 변수로 현재 다리에 있는 무게를 측정하고, 다리를 건넌 차를 가감하는 형식으로 구현.

from collections import deque

def solution(bridge_length, weight, truck_weights):
     
    time = 0
    bridge = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)
    
    currentWeight = 0
    while bridge:
        time+=1

        currentWeight -= bridge.popleft()

        if truck_weights:
            if currentWeight + truck_weights[0] <= weight:
                currentWeight+= truck_weights[0]
                bridge.append(truck_weights.popleft())

            else: 
                bridge.append(0)
            
    return time
