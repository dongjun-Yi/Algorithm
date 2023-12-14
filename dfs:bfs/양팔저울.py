k = int(input())

arr = list(map(int, input().split()))
total = sum(arr)

res = set()


def dfs(L, sum):
  global res
  if L == k:
    if sum > 0:
      res.add(sum)
  else:
    dfs(L + 1, sum + arr[L])
    dfs(L + 1, sum - arr[L])
    dfs(L + 1, sum)


dfs(0, 0)
print(total - len(res))
