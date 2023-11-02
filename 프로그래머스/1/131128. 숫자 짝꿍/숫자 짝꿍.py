def solution(X, Y):
    result = ''
    a = [0] * 10
    b = [0] * 10
    
    for i in X:
        value = int(i)
        a[value] += 1
    
    for i in Y:
        value = int(i)
        b[value] += 1
    
    # 최대가 되게끔 result 변수에 더함
    for i in range(9,-1,-1):
        value = str(i) * min(a[i],b[i])
        result += value
        
    if len(result) == 0:
        return '-1'
    if result[0] == '0':
        return '0'
              
    return result