import sys
def solution(sizes):
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            sizes[i][0], sizes[i][1] = sizes[i][1], sizes[i][0]
    max_x = -sys.maxsize
    max_y = -sys.maxsize
    
    for x,y in sizes:
        max_x = max(x, max_x)
        max_y = max(y, max_y)
    print(max_x, max_y)
    answer = max_x * max_y
                    
    return answer