def solution(participant, completion):
    answer = 0
    d = {}
    for key in participant:
        d[key] = 0
    for key in participant:
        d[key] +=1
        
    for key in completion:
        d[key] -=1
    for k in d:
        if d[k] == 1:
            answer = k
    return answer