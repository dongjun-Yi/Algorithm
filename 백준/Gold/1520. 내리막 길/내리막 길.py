import sys

input = sys.stdin.readline
m, n = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(m)]

# 이동방향 : 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

dp = [[-1] * n for _ in range(m)]


def dfs(x, y):

  # base case
  if x == (m - 1) and y == (n - 1):
    return 1

  # 이미 방문한 적이 있다면 그 위치에서 출발하는 경우의 수를 리턴
  if dp[x][y] != -1:
    return dp[x][y]

  cnt = 0
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if nx < 0 or nx >= m or ny < 0 or ny >= n:
      continue
    if g[nx][ny] < g[x][y]:
      cnt += dfs(nx, ny)

  dp[x][y] = cnt
  return dp[x][y]


print(dfs(0, 0))
