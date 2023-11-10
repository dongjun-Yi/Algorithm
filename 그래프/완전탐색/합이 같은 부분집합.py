import sys

n = int(input())

arr = list(map(int, input().split()))
total = sum(arr)


def dfs(L, sum):
  # 가지치기 : 합이 전체 합의 반을 넘어가면 부분집합끼리 합이 같을 수 없으므로 return
  if sum > total // 2:
    return
  if L == n:
    if sum == (total - sum):
      print("YES")
      sys.exit(0)
  else:
    dfs(L + 1, sum + arr[L])
    dfs(L + 1, sum)


dfs(0, 0)
print("NO")
