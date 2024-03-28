from itertools import combinations

def solution(relation):
    row = len(relation)
    col = len(relation[0])
    
    candidates = []
    li = list(range(col))
    
    for i in range(1, col + 1):
        candidates.extend(combinations(li, i))

    # 유일성
    unique = []
    for c in candidates:
        tmp = []
        for item in relation:
            tmp.append(tuple(item[i] for i in c))
            
        if len(set(tmp)) == row:
            unique.append(c)
    
    answer = set(unique)
    
    # 최소성
    for i in range(len(unique)):
        for j in range(i+1, len(unique)):
            if len(unique[i]) == len(set(unique[i]) & set(unique[j])):
                if unique[j] in answer:
                    answer.remove(unique[j])
                    
    return len(answer)