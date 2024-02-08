from collections import deque

def bfs(x,y,maps,row, col):
    q = deque([(x,y)])
    eats = int(maps[x][y])
    maps[x][y] = 'X'
    
    # 상하좌우
    dx = [1,-1,0,0]
    dy = [0,0,-1,1]

    
    while q:
        x,y = q.popleft()
    
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= row or ny < 0 or ny>=col:
                continue
                
            if maps[nx][ny] !='X':
                eats += int(maps[nx][ny])
                maps[nx][ny] = 'X'
                q.append((nx,ny))
                
    return eats
        
def solution(maps):
    answer = []
    maps = list(map(list, maps))

    row, col = len(maps), len(maps[0])
    
    for i in range(row): # O(n*n) = O(10^4)
        for j in range(col):
            if maps[i][j] !='X':
                answer.append(bfs(i,j,maps, row, col))
                
    if not answer:
        return [-1]
    
    answer.sort()
    return answer