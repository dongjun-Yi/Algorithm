n = int(input())
lines = list(map(int, input().split()))

res = [0] * n

for i in range(n):
  cnt = 0
  for j in range(n):
    # 자기 자리 찾음
    if cnt == lines[i] and res[j] == 0:
      res[j] = i + 1
      break
    elif res[j] == 0:
      cnt += 1

for x in res:
  print(x, end=' ')