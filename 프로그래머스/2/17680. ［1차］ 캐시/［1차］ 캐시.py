import sys
def solution(cacheSize, cities):
    answer = 0 
    d = []
    
    if cacheSize == 0:
        answer = 5 * len(cities)
        return answer
    
    for i in range(len(cities)):
        # 대소문자 구분 안하므로
        city = cities[i].lower()
        
        # cahce miss
        if city not in d:
            if len(d) == cacheSize:
                # LRU 알고리즘을 사용하므로 cache에서 가장 오래된거 삭제
                d.pop(0)
            d.append(city)
            answer+=5
            
        # cache hit
        else:
            index = d.index(city)
            d.append(d.pop(index))
            answer+=1

    return answer
