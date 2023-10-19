def solution(strArr):
    answer = []
    
    for word in strArr:
        if "ad" in word:
            continue
        answer.append(word)

    return answer