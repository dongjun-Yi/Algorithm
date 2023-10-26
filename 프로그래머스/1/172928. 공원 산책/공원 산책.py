def solution(park, routes):
    answer = []
    
    park = list(park)
    
    for i in range(len(park)):
        park[i] = list(park[i])
        
    row = len(park[i]) 
    col = i + 1
    
    
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                start_index = (i,j)
                break
    
    direction = ["N", "S", "W", "E"]
    # 상하좌우 방향 설정
    move = [(-1,0), (1,0), (0,-1),(0,1)]
    
    for r in routes:
        op, n = r.split()
        idx = direction.index(op)
        x,y = move[idx]
        x,y = int(n) * x, int(n) * y
        nx,ny = start_index[0] + x, start_index[1] + y
        
        if nx < 0 or nx>=col or ny<0 or ny>=row:
            continue
        
        # X를 탐색하기 위한 시작위치와 끝위치 할당
        if start_index[0] > nx:
            start_x = nx
            end_x = start_index[0]
        else:
            start_x = start_index[0]
            end_x = nx
        
        if start_index[1] > ny:
            end_y = start_index[1]
            start_y = ny
        else:
            start_y = start_index[1]
            end_y = ny
        
        # 이동하는 중간에 X가 있는지 확인하기 위한 flag 변수
        flag = True
        
        for i in range(start_x, end_x + 1):
            for j in range(start_y, end_y+ 1):
                if park[i][j] == "X":
                    flag= False
                    break
        if flag:
            start_index = (nx,ny)

    return start_index[0], start_index[1]