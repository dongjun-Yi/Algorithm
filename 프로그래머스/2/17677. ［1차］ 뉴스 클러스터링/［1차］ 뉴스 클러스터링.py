def solution(str1, str2):
    answer = 0
    s1 = []
    s2 = []
    
    for i in range(len(str1)-1):
        tmp = ''
        tmp = str1[i] + str1[i+1]
        if tmp.isalpha():
            tmp = tmp.lower()
            s1.append(tmp)  
        else:
            continue

    for i in range(len(str2)-1):
        tmp = ''
        tmp = str2[i] + str2[i+1]
        if tmp.isalpha():
            tmp = tmp.lower()
            s2.append(tmp)  
        else:
            continue
            
    cnt1, cnt2 = 0,0

    cnt2 = len(s1 + s2)
    for s in s1:
        if s in s2:
            s2.remove(s)
            cnt1+=1
    cnt2 -= cnt1
    try:
        answer = int((cnt1 / cnt2) * 65536)
    except ZeroDivisionError:
        answer = 65536
        
    return answer