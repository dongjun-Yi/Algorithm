n = int(input())
arr = []

arr = [list(map(int, input().split())) for _ in range(n)]

m = int(input())

for _ in range(m):
  row, direction, cnt = map(int, input().split())
  for _ in range(cnt):
    if direction == 0:
      arr[row - 1].append(arr[row - 1].pop(0))
    else:
      arr[row - 1].insert(0, arr[row - 1].pop())

lt = 0
rt = n - 1
res = sum(arr[0][lt:rt + 1])

for i in range(1, n):
  # 탐색변수 i가 절반을 넘었다면
  if i > (n // 2):
    lt -= 1
    rt += 1
  else:
    lt += 1
    rt -= 1
  res += sum(arr[i][lt:rt + 1])

print(res)