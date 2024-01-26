from collections import deque
from collections import Counter

def solution(queue1, queue2):
    
    q1, q2 = deque(queue1),deque(queue2)
    s1, s2 = sum(queue1), sum(queue2)
    
    limit = len(q1) * 3
    total = s1 + s2

    if total % 2 != 0:
        return -1
    
    cnt = 0
    
    while True:
        if s1 > s2:
            element = q1.popleft()
            q2.append(element)
            s1 -= element
            s2 += element
            cnt +=1 
        elif s1 < s2:
            element = q2.popleft()
            q1.append(element)
            s1 += element
            s2 -= element
            cnt +=1 
        else:
            break
        
        if cnt == limit:
            return -1
    
    return cnt