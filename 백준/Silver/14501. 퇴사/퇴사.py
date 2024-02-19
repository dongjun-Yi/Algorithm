import sys

n = int(input())
times = []
pays = []

for _ in range(n):
  t, p = map(int, input().split())
  times.append(t)
  pays.append(p)

times.insert(0, 0)
pays.insert(0, 0)

res = -sys.maxsize


def dfs(time, pay):
  global res

  if time == n + 1:
    if res < pay:
      res = pay
  else:
    if time + times[time] <= n + 1:
      dfs(time + times[time], pay + pays[time])
    dfs(time + 1, pay)


dfs(1, 0)
print(res)
