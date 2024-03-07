import sys

n = int(input())
data = list(map(int, input().split()))

add, sub, mul, div = map(int, input().split())

min_value = sys.maxsize
max_value = -sys.maxsize


def dfs(L, now):
  global max_value, min_value, add, sub, mul, div

  if L == n:  # 종료 조건
    min_value = min(min_value, now)
    max_value = max(max_value, now)

  else:
    if add > 0:
      add -= 1
      dfs(L + 1, now + data[L])
      add += 1
    if sub > 0:
      sub -= 1
      dfs(L + 1, now - data[L])
      sub += 1
    if mul > 0:
      mul -= 1
      dfs(L + 1, now * data[L])
      mul += 1
    if div > 0:
      div -= 1
      dfs(L + 1, int(now / data[L]))
      div += 1


dfs(1, data[0])
print(max_value)
print(min_value)
