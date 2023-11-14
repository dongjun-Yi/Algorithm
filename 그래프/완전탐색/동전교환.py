import sys

n = int(input())

coins = list(map(int, input().split()))

m = int(input())
res = sys.maxsize

coins.sort(reverse=True)


# L : 사용한 동전의 개수
def dfs(L, sum):
  global res
  # backtracking : 최소의 동전 개수를 구하는데, 만약 트리의 깊이가 res에 기록된 값보다 클 경우 탐색 불필요
  if res < L:
    return
  if sum < 0:
    return
  if sum == 0:
    if res > L:
      res = L
  else:
    for i in range(n):
      dfs(L + 1, sum - coins[i])


dfs(0, m)

print(res)
