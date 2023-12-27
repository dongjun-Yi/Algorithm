n, m = map(int, input().split())

res = [0] * m

visited = [False] * (n + 1)


def dfs(L):
  if L == m:
    for x in res:
      print(x, end=' ')
    print()
  else:
    for i in range(1, n + 1):
      if not visited[i]:
        res[L] = i
        visited[i] = True
        dfs(L + 1)
        visited[i] = False


dfs(0)
