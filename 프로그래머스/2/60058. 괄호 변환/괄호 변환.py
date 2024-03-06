def check(s):
    stack = []
    for x in s:
        if x == '(':
            stack.append(x)
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False
    
    return True

def solution(p):
    answer = ''
    
    if p == '':
        return p
    
    left_cnt, right_cnt = 0, 0
    for x in p:
        if x == '(':
            left_cnt += 1
        else:
            right_cnt += 1
    
        if left_cnt == right_cnt: # 균형잡힌 문자열
            u = p[:left_cnt + right_cnt]
            v = p[left_cnt + right_cnt:]
            break
            
    if check(u):
        return u + solution(v)
    
    
    answer = "(" + solution(v) + ")"
    u = u[1:-1]
    
    for i in range(len(u)):
        if u[i] == '(':
            answer += ')'
        else:
            answer += '('
    return answer