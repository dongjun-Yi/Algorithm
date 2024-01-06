def solution(n, left, right):
    # 입력값 n의 제한이 10^^7이기 때문에 시간 복잡도 O(n^2) 미만으로 풀이.
    answer = []

    # 몫과 나머지를 구한 후 2차원 배열 a[몫][나머지]의 값은 몫과 나머지중 큰 값이 들어가게 된다.
    for i in range(left, right+1):
        x = i //n # 행
        y = i % n # 열
        answer.append(max(x,y) + 1)
    
    return answer
    