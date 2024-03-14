def solution(land):
    answer = 0
    d = [[0] * 4 for _ in range(len(land))]
    
    for i in range(4):
        d[0][i] = land[0][i]
    for i in range(1, len(land)):
        d[i][0] = max(d[i-1][1], d[i-1][2], d[i-1][3]) + land[i][0]
        d[i][1] = max(d[i-1][0], d[i-1][2], d[i-1][3]) + land[i][1]
        d[i][2] = max(d[i-1][0], d[i-1][1], d[i-1][3]) + land[i][2]
        d[i][3] = max(d[i-1][0], d[i-1][1], d[i-1][2]) + land[i][3]
    
    return max(d[len(land)-1])