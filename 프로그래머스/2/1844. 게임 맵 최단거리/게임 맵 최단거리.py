from collections import deque
# 방향 : 동서남북
dx = [0,0,1,-1]
dy = [-1,1,0,0]

def bfs(maps, i,j,n,m, visited):
    q = deque([(i,j)])
    visited[i][j] = True
    
    while q:
        x,y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >=n or ny < 0 or ny>=m:
                continue
                
            if not visited[nx][ny] and maps[nx][ny] !=0:
                visited[nx][ny] = True
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx,ny))
    return maps[n-1][m-1]
    
def solution(maps):
    answer = 0
    # 세로 길이
    n = len(maps)
    # 가로 길이
    m = len(maps[0])
    
    visited = [[False]*m for _ in range(n)]
    answer = bfs(maps, 0,0,n,m,visited)
    if answer == 1:
        return -1
    return answer