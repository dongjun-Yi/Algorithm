def solution(topping):
    answer = 0
    n = len(topping)
    s1 = {}
    s2 = set()
    for i in range(n):
        if topping[i] in s1:
            s1[topping[i]] += 1
            continue
        s1[topping[i]] = 1
    
    for i in range(n-1, 0, -1):
        s1[topping[i]] -= 1
        s2.add(topping[i])

        if s1[topping[i]] == 0:
            del s1[topping[i]]
        
        if len(s1) == len(s2):
            answer+=1
        
    
    return answer