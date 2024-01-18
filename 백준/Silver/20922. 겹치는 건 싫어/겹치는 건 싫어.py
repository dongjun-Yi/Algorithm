n, k = map(int, input().split())

d = dict()

arr = list(map(int, input().split()))

res = -9999

lt = 0
rt = 0

while rt < n:
  if arr[rt] in d:

    if d[arr[rt]] + 1 > k:
      d[arr[lt]] -= 1
      lt += 1
    else:
      d[arr[rt]] += 1
      rt += 1

  else:
    d[arr[rt]] = 1
    rt += 1
  res = max(res, rt - lt)
print(res)
