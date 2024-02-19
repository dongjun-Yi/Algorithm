n = int(input())

g = []

for _ in range(n):
  g.append(list(map(int, input().split())))

dy = [[0] * n for _ in range(n)]
dy[0][0] = g[0][0]

for i in range(1, n):
  for j in range(i+1):
    if j == 0:
      dy[i][j] = dy[i-1][j] + g[i][j]
    if j == i:
      dy[i][j] = dy[i-1][j-1] + g[i][j]
    dy[i][j] = max(dy[i-1][j-1], dy[i-1][j]) + g[i][j]

print(max(dy[n-1]))