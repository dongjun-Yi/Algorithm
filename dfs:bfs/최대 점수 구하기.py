n, m = map(int, input().split())
pb = []
for _ in range(n):
  a, b = map(int, input().split())
  pb.append((a, b))

res = 0


def dfs(L, sum, time):
  global res
  # 시간이 m을 초과했을 경우 return
  if time > m:
    return
  if L == n:
    if res < sum:
      res = sum
  else:
    dfs(L + 1, sum, time)
    dfs(L + 1, sum + pb[L][0], time + pb[L][1])


dfs(0, 0, 0)
print(res)
