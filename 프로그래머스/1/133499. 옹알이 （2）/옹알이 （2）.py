def solution(babbling):
    answer = 0
    words = ["aya", "ye", "woo", "ma"]
    for b in babbling:
        for w in words:
            if w * 2 not in b:
                b = b.replace(w, ' ')
                
        if b.isspace():
            answer+=1
        
    return answer