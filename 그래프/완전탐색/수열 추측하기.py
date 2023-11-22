import sys

n, f = map(int, input().split())

res = [0] * n
b = [1] * n
ch = [0] * (n + 1)

for i in range(1, n):
  b[i] = (b[i - 1] * (n - i)) // i


def dfs(L, sum):
  if L == n and sum == f:
    for x in res:
      print(x, end=' ')
    sys.exit()
  else:
    for i in range(1, n + 1):
      if not ch[i]:
        res[L] = i
        ch[i] = 1
        dfs(L + 1, sum + (res[L] * b[L]))
        ch[i] = 0


dfs(0, 0)
