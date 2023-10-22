def solution(s, skip, index):
    answer = ''
    alp = "abcdefghijklmnopqrstuvwxyz"
    
    for ch in skip: # ch => skip의 문자 하나하나
        if ch in alp:
            alp = alp.replace(ch, "") # 알파벳 안에 skip 문자들 제거
    
    for word in s:
        tmp = alp[(alp.index(word) + index) % len(alp)] # 각문자의 시작위치 + index를 alpha의 길이로 나눈 나머지를 알파벳으로 변환
        answer += tmp
    return answer