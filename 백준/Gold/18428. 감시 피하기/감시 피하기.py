from itertools import combinations
import sys

n = int(input())
g = []
teacher = []
blank = []

for i in range(n):
  g.append(list(input().split()))
  for j in range(n):
    if g[i][j] == 'T':
      teacher.append((i, j))
    if g[i][j] == 'X':
      blank.append((i, j))

cnt = 3


def check():
  for x, y in teacher:  #동서남북 확인
    # 서쪽
    ny = y
    while ny >= 0:
      if g[x][ny] == 'S':
        return False
      if g[x][ny] == 'O':
        break
      ny -= 1
    # 동쪽
    ny = y
    while ny < n:
      if g[x][ny] == 'S':
        return False
      if g[x][ny] == 'O':
        break
      ny += 1
    nx = x
    # 북쪽
    while nx >= 0:
      if g[nx][y] == 'S':
        return False
      if g[nx][y] == 'O':
        break
      nx -= 1
    nx = x
    # 남쪽
    while nx < n:
      if g[nx][y] == 'S':
        return False
      if g[nx][y] == 'O':
        break
      nx += 1

  return True


for c in list(combinations(blank, 3)):
  for i in range(3):
    cx, cy = c[i]
    g[cx][cy] = 'O'

  if check():
    print("YES")
    sys.exit()
  for i in range(3):
    cx, cy = c[i]
    g[cx][cy] = 'X'

else:
  print("NO")
