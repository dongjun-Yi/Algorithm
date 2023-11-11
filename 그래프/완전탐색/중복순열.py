n, m = map(int, input().split())

res = [0] * m

# 총 경우의 수
cnt = 0


def dfs(L):
  global cnt
  if L == m:
    cnt += 1
    for x in res:
      print(x, end=' ')
    print()
  else:
    for i in range(1, n + 1):
      res[L] = i
      dfs(L + 1)


dfs(0)
print(cnt)
