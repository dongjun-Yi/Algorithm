from itertools import combinations
import copy, sys

n, m = map(int, input().split())
walls = []
g = []
virus = []
for i in range(n):
  g.append(list(map(int, input().split())))
  for j in range(m):
    if g[i][j] == 0:
      walls.append((i, j))
    if g[i][j] == 2:
      virus.append((i, j))

# 동서남북
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def dfs(x, y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if nx < 0 or nx >= n or ny < 0 or ny >= m or new_g[nx][ny] == 1:
      continue

    if new_g[nx][ny] == 0:
      new_g[nx][ny] = 2
      dfs(nx, ny)


result = -sys.maxsize
for wall in list(combinations(walls, 3)):
  new_g = copy.deepcopy(g)
  cnt = 0
  visited = [[False] * m for _ in range(n)]
  
  for i in range(3):
    x, y = wall[i]
    new_g[x][y] = 1

  for i in range(len(virus)):
    x, y = virus[i]
    visited[x][y] = True
    dfs(x, y)

  for i in range(n):
    for j in range(m):
      if new_g[i][j] == 0:
        cnt += 1

  result = max(result, cnt)

print(result)
