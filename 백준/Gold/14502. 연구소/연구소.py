from itertools import combinations
import sys, copy

n, m = map(int, input().split())

g = [list(map(int, input().split())) for _ in range(n)]

blank = []

for i in range(n):
  for j in range(m):
    if g[i][j] == 0:
      blank.append((i, j))

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):
  visited[x][y] = True

  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if nx < 0 or nx >= n or ny < 0 or ny >= m:
      continue

    if new_g[nx][ny] == 1:
      continue

    if new_g[nx][ny] == 0 and not visited[nx][ny]:
      new_g[nx][ny] = 2
      dfs(nx, ny)


res = -sys.maxsize

for c in list(combinations(blank, 3)):
  cnt = 0
  t = []
  visited = [[False] * m for _ in range(n)]
  new_g = copy.deepcopy(g)

  for i in range(3):
    cx, cy = c[i]
    new_g[cx][cy] = 1

  for i in range(n):
    for j in range(m):
      if new_g[i][j] == 2:
        t.append((i, j))
        dfs(i, j)

  for i in range(n):
    for j in range(m):
      if new_g[i][j] == 0:
        cnt += 1

  res = max(res, cnt)
print(res)
