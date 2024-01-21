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