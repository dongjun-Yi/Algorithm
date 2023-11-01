def solution(s):
    answer = 0
    x_cnt, x_not_cnt = 1, 0
    x = s[0]
    # 문자열의 길이가 1인 경우는 1 return
    if len(s) ==1:
        answer = 1
        
    for i in range(1, len(s)):
        # 문자열 분할 후 다시 문자열 개수 count를 위한 구문
        if x_cnt ==0:
            x = s[i]
            x_cnt+=1
            if x_cnt!=x_not_cnt and i == len(s) -1:
                answer+=1
                break
            continue
            
        # x와 같은 값, x와 다른 값 count 증가
        if x!=s[i]:
            x_not_cnt+=1
        else:
            x_cnt+=1
        
        # 문자 개수가 같은 때 문자 count변수 초기화
        if x_cnt == x_not_cnt:
            answer+=1
            # count변수 다 0으로 초기화
            x_cnt = 0
            x_not_cnt = 0
            continue
            
        # 마지막에 남은 문자열은 그냥 문자열 분할
        if x_cnt!=x_not_cnt and i == len(s) -1:
            answer+=1
        
        
    return answer