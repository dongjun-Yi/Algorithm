import sys
def solution(keymap, targets):
    answer = []
    for target in targets:
        sum = 0
        for t in target:
            tmp = sys.maxsize
            for i in range(len(keymap)):
                if t in keymap[i]:
                    tmp= min(tmp, keymap[i].index(t) + 1)
            sum += tmp
            if tmp == sys.maxsize:
                answer.append(-1)
                break
        else:
            answer.append(sum)
    
    return answer