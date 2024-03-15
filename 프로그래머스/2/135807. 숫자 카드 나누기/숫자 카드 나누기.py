import math
def solution(arrayA, arrayB):
    answer = 0
    a = arrayA[0]
    for i in range(1, len(arrayA)):
        a = math.gcd(a, arrayA[i])
    
    for x in arrayB:
        if x % a== 0:
            break
    else:
        answer = a
    
    b = arrayB[0]
    for i in range(1, len(arrayB)):
        b = math.gcd(b, arrayB[i])
    
    for x in arrayA:
        if x % b== 0:
            break
    else:
        if answer < b:
            answer =b
    return answer