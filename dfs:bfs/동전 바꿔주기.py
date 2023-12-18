t = int(input())

n = int(input())
# 화페 단위
coins = []
# 각 동전의 개수
coin_cnt = []

for _ in range(n):
  a, b = map(int, input().split())
  coins.append(a)
  coin_cnt.append(b)

res = 0

def dfs(L, sum):
  global res
  if sum > t:
    return
  if L == n:
    if sum == t:
      res += 1
  else:
    for i in range(coin_cnt[L] + 1):
      dfs(L + 1, sum + (i * coins[L]))


dfs(0, 0)
print(res)
