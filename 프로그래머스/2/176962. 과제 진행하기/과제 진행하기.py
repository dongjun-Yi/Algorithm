from collections import deque

def convert_time(s):
    h, m = map(int, s.split(':'))
    return h * 60 + m

def solution(plans):
    answer = []
    new_plans = []
    
    for name, start, playtime in plans:
        new_plans.append([name, convert_time(start), int(playtime)])
    
    new_plans.sort(key = lambda x : x[1])
    homework = deque()
    left_time = 0
        
    for i in range(len(new_plans)):
        name, start, playtime = new_plans[i]
        
        while homework:
            h_name, h_playtime = homework.pop()

            if left_time >= h_playtime:
                left_time -= h_playtime
                answer.append(h_name)
            else:
                homework.append((h_name, h_playtime - left_time))
                break
                
        homework.append((name, playtime))
        
        if i < len(plans) - 1: # 마지막 요소가 아니라면
            next_start = new_plans[i+1][1]
            left_time = next_start - start

    while homework:
        name = homework.pop()[0]
        answer.append(name)
        
    return answer