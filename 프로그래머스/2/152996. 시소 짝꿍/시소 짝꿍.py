from collections import Counter

def solution(weights):
    answer = 0
    
    weight_dict = Counter(weights)
    
    for key, val in weight_dict.items():
        if val > 1:
            answer += (val *(val-1)) //2
        if key * 2 in weight_dict:
            answer += val* weight_dict[key *2]
        if (key * 3) % 2 ==0 and (key * 3) // 2 in weight_dict:
            answer += val* weight_dict[(key * 3) // 2]
        if (key * 4) % 3 ==0 and (key * 4) // 3 in weight_dict:
            answer += val* weight_dict[(key * 4) // 3]
            
    return answer