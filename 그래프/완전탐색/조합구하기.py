n, m = map(int, input().split())

res = [0] * m
cnt = 0


def dfs(L, s):
  global cnt
  if L == m:
    for x in res:
      print(x, end=' ')
    print()
    cnt += 1
  else:
    for i in range(s, n + 1):
      res[L] = i
      dfs(L + 1, i + 1)


dfs(0, 1)
print(cnt)