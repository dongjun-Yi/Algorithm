import sys

input = sys.stdin.readline

n, m = map(int, input().split())
standard = []
for _ in range(n):
  a, b = input().split()
  standard.append((a, int(b)))

standard.sort(key=lambda x: x[1])

for _ in range(m):
  power = int(input())

  lt = 0
  rt = n - 1

  while lt <= rt:
    mid = (lt + rt) // 2

    if power <= standard[mid][1]:
      res = standard[mid][0]
      rt = mid - 1
    else:
      lt = mid + 1

  print(res)
