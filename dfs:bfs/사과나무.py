from collections import deque

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]

# 동서남북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

visited = [[False] * n for _ in range(n)]

# 사과의 합
res = 0
# BFS Level
L = 0


def bfs(x, y):

  global res, L
  q = deque([(x, y)])
  visited[x][y] = True
  res = g[x][y]

  while True:
    # 다이아몬드 격자 모양으로 합을 구하기 위한 조건으로, nXn 모양 정사각형에서 n//2 일 때 다이아몬드 모양 성립
    if L == n // 2:
      break
    diamond_size = len(q)

    for j in range(diamond_size):
      x, y = q.popleft()

      for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or ny < 0 or nx >= n or ny >= n:
          continue
        if not visited[nx][ny]:
          visited[nx][ny] = True
          res += g[nx][ny]
          q.append((nx, ny))
    # BFS 탐색 레벨
    L += 1


bfs(n // 2, n // 2)
print(res)
