from collections import deque

def solution(order):
    answer = 0
    container = deque(list(range(1, len(order) + 1)))
    sub = deque()
    
    for x in order:
        if container and sub and x < container[0] and x < sub[0]:
            break
        
        if sub and x == sub[0]:
            answer += 1
            sub.popleft()
            continue
        
        while container and x != container[0]:
            sub.appendleft(container.popleft())
        if container and x == container[0]:
            answer += 1
            container.popleft()
            continue
            
                
    return answer