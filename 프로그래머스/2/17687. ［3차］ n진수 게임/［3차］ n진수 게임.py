# 진법 변환
def convert(n, base):
    arr= "0123456789ABCDEF"
    q, r= divmod(n, base)
    
    if q == 0:
        return arr[r]
    else:
        return convert(q,base) + arr[r]
    
def solution(n, t, m, p):
    answer = ''
    tmp =''
    # 진법변환 후 이어 붙임
    for i in range(m*t):
        tmp +=str(convert(i, n))
    
    while len(answer) < t:
        answer +=tmp[p-1]
        p+=m
        
    return answer