def check_perfect(u):
    stack = []
    
    for x in u:
        if stack and x == ')':
            if stack[-1] == ')':
                return False
            stack.pop()
            continue
        stack.append(x)
        
    if stack:
        return False
    return True

def make_uv(p):
    left_par_count, right_par_count = 0,0
    for i in range(len(p)):
        if p[i] == '(':
            left_par_count +=1
        else:
            right_par_count +=1
        if left_par_count == right_par_count:
            return p[:i+1], p[i+1:]
        
def solution(p):
    answer = ''
    
    if len(p) == 0:
        return ""
    
    u, v = make_uv(p)
    
    if check_perfect(u):
        return u + solution(v)
    
    else:
        answer = '('
        answer += solution(v)
        answer += ')'
        
        for x in u[1:len(u)- 1]:
            if x == '(':
                answer += ')'
            else:
                answer += '('
        return answer
