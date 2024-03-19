from collections import deque
import sys

def solution(board):
    answer = 0
    n = len(board)
    m = len(board[0])
    q = deque()
    
    distance = [[sys.maxsize] * m for _ in range(n)]
    
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                q.append((i,j,0))
                distance[i][j] = 0
    
    # 상하좌우
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    while q:
        x, y, time = q.popleft()
        
        if board[x][y] == 'G':
            return time
        
        for i in range(4):
            nx = x
            ny = y 
            
            while 0<=nx + dx[i]<n and 0<=ny + dy[i]<m and board[nx+dx[i]][ny+dy[i]] != 'D':
                nx += dx[i]
                ny += dy[i]
            
            if distance[nx][ny] > time + 1:
                distance[nx][ny] = time + 1
                q.append((nx, ny, time + 1))
                
    return -1