from collections import deque

m, n = map(int, input().split())
graph = []

for _ in range(n):
  graph.append(list(map(int, input().split())))

q = deque()
for i in range(n):
  for j in range(m):
    if graph[i][j] == 1:
      q.append((i, j))

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs():
  while q:
    cur = q.popleft()

    for i in range(4):
      nx = cur[0] + dx[i]
      ny = cur[1] + dy[i]

      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue

      if graph[nx][ny] == 0:
        graph[nx][ny] = graph[cur[0]][cur[1]] + 1
        q.append((nx, ny))


bfs()
res = 0

for i in graph:
  for j in i:
    if j == 0:
      print(-1)
      exit(0)
  res = max(res, max(i))

print(res - 1)
