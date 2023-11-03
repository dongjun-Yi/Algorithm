
def solution(elements):
    result = set()
    
    elementLen = len(elements)
    
    # [7, 9, 1, 1, 4, 7, 9, 1, 1, 4]
    elements = elements * 2
    
    # 길이가 i인 연속 부분 수열 개수 구하기
    for i in range(elementLen):
        for j in range(elementLen):
            result.add(sum(elements[j:j+i+1]))
    return len(result)