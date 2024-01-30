import sys
from collections import deque

n, m, k = map(int, input().split())

g = [[0 for _ in range(m)] for _ in range(n)]

for _ in range(k):
  r, c = map(int, input().split())
  g[r - 1][c - 1] = 1

res = -sys.maxsize

# 상하좌우
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
  q = deque([(x, y)])
  g[x][y] = 0
  cnt = 0
  while q:
    cnt += 1
    x, y = q.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if g[nx][ny] == 1:
        g[nx][ny] = 0
        q.append((nx, ny))
  return cnt


for i in range(n):
  for j in range(m):
    if g[i][j] == 1:
      res = max(res, bfs(i, j))

print(res)
