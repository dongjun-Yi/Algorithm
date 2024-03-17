from collections import deque
def bfs(start, end, maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if maps[i][j] == start:
                q = deque([(i,j,0)])
                visited[i][j] = True
    # 동남서북
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    
    while q:
        x,y, time = q.popleft()
        
        if maps[x][y] == end:
            return time
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >=n or ny <0 or ny>=m:
                continue
            if maps[nx][ny] != 'X' and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, time + 1))
    return -1

def solution(maps):
    path1 = bfs('S','L', maps)
    path2 = bfs('L','E', maps)

    if path1 != -1 and path2 != -1:
        return path1 + path2
    
    return -1