n = int(input())
m = int(input())
g = [[] * (n + 1) for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
  a, b = map(int, input().split())
  g[a].append(b)
  g[b].append(a)

result = 0


def dfs(v):
  global result
  for x in g[v]:
    if visited[x]:
      continue
    visited[x] = True
    result += 1
    dfs(x)


visited[1] = True
dfs(1)

print(result)
