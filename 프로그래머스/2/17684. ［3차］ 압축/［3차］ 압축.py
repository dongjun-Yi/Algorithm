def solution(msg):
    answer = []
    d = init_dictionary()

    if len(msg) == 1:
        return [d[msg[0]]]
    i = 0
    big = 26
    j = 0

    while True:
        
        if i >= len(msg):
            break
        word = msg[i]
        last = word
        
        for j in range(i+1, len(msg)):
            last = word
            word = msg[i:j + 1]
            if word in d.keys():
                continue
            break
        
        if word in d.keys():
            answer.append(d[word])
            break
        else:
            answer.append(d[last])
            
        if word not in d.keys():
            big = big + 1
            d[word] = big
        i = i + len(last)
    
    return answer

def init_dictionary():
    d = {}
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    for i in range(1, 27):
        d[alpha[i-1]] = i
    return d
        