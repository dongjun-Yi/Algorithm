def solution(arr):
    answer = []
    
    for x in arr:
        if answer and answer[-1] == x:
            continue
        answer.append(x)
    
    return answer