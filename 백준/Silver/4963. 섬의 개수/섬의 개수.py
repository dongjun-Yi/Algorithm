# 섬의 개수 : 대각선으로도 섬으로 한 섬으로 판정하여 상하좌우 대가선을 체크해줘야함

import sys

sys.setrecursionlimit(100000)

# 상하좌우 좌대각선, 우대각선
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]


def dfs(x, y):

  if x < 0 or x >= m or y < 0 or y >= n:
    return False
  if graph[x][y] == 0:
    return False

  if graph[x][y] == 1:
    graph[x][y] = 0
    dfs(x - 1, y)
    dfs(x + 1, y)
    dfs(x, y - 1)
    dfs(x, y + 1)
    dfs(x - 1, y - 1)
    dfs(x - 1, y + 1)
    dfs(x + 1, y - 1)
    dfs(x + 1, y + 1)
  return True


while True:
  cnt = 0
  graph = []
  n, m = map(int, input().split())
  visited = [[False] * n for _ in range(m)]
  if n == 0 and m == 0:
    break
  for _ in range(m):
    graph.append(list(map(int, input().split())))

  for i in range(m):
    for j in range(n):
      if dfs(i, j):
        cnt += 1
  print(cnt)
