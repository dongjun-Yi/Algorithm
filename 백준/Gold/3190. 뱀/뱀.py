n = int(input())
k = int(input())

g = [[0] * n for _ in range(n)]

for _ in range(k):
  a, b = map(int, input().split())
  g[a - 1][b - 1] = 1

directions_change = {}
L = int(input())

for _ in range(L):
  a, b = input().split()
  directions_change[int(a)] = b

time = 0

# 동 남 서 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

x, y = 0, 0
g[x][y] = 2
direction = 0
q = [(x, y)]

while True:
  time += 1
  nx = x + dx[direction]
  ny = y + dy[direction]

  # 벽에 부딪히면 종료
  if nx < 0 or ny < 0 or nx >= n or ny >= n:
    break

  if g[nx][ny] != 2:
    if g[nx][ny] == 0:  # 사과가 없는 경우 이동후 꼬리 제거
      g[nx][ny] = 2
      q.append((nx, ny))
      px, py = q.pop(0)
      g[px][py] = 0

    if g[nx][ny] == 1: # 사과가 있을 경우 꼬리 그자리 그대로 두기
      g[nx][ny] = 2
      q.append((nx, ny))
  else:
    break

  if time in directions_change.keys():
    if directions_change[time] == 'D':
      direction += 1
      if direction == 4:
        direction = 0
    else:
      direction -= 1
      if direction == -1:
        direction = 3
  x, y = nx, ny

print(time)
