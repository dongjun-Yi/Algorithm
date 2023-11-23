import sys
def solution(s):
    answer = sys.maxsize
    
    # i는 문자를 자르는 단위
    for i in range(1, len(s)+1):
        b = ''
        tmp = s[:i]
        cnt = 1
        # 가장 짧은 문자열 찾기
        for j in range(i,len(s), i):
            if tmp == s[j:j+i]:
                cnt +=1
            else:
                if cnt >=2:
                    b += str(cnt) + tmp
                else:
                    b+= tmp
                # 기준 문자 바꾸기
                tmp = s[j:j+i]
                cnt = 1
        # 남아있는 문자열에 대해 처리
        if cnt >= 2:
            b += str(cnt) + tmp
        else:
            b += tmp
        
        answer = min(answer, len(b))
    return answer
