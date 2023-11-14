from collections import deque

# 동서남북
dx = [0,0,1,-1]
dy = [-1,1,0,0]

def bfs(x,y, p):
    start = []
    
    # 응시자가 앉은 위치 찾기
    for i in range(5):
        for j in range(5):
            if p[i][j] == 'P':
                start.append([i,j])
    
    for s in start:
        q = deque([s])
        # 방문 처리 기록
        visited = [[False] * 5 for _ in range(5)] 
        visited[s[0]][s[1]] = True
        
        # 응시자간 거리 기록
        distance = [[0] * 5 for _ in range(5)] 
        
        while q:
            x,y = q.popleft()
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                
                if nx <0 or nx>=5 or ny< 0 or ny>=5 or visited[nx][ny]:
                    continue
                
                # 빈자리일 경우 응시간의 거리를 측정하기 위해 거리를 기록
                if p[nx][ny] == 'O':
                    q.append((nx,ny))
                    visited[nx][ny] = True
                    distance[nx][ny] = distance[x][y] + 1
                    
                # 응시자인 경우 거리가 2 미만일 경우 거리두기 실패
                if p[nx][ny] == 'P' and distance[x][y] <2:
                    return 0
    return 1

def solution(places):
    answer = []
    for p in places:
        answer.append(bfs(0,0,p))
    return answer