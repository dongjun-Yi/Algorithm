# decision algorithm
k, n = map(int, input().split())

lines = []

for _ in range(k):
  lines.append(int(input()))

lines.sort()

lt = 1
rt = lines[k - 1]


def check_lines(mid):
  cnt = 0
  for x in lines:
    cnt += x // mid
  return cnt


res = 0

while lt <= rt:
  mid = (lt + rt) // 2
  if check_lines(mid) >= n:
    res = mid
    lt = mid + 1
  else:
    rt = mid - 1

print(res)
