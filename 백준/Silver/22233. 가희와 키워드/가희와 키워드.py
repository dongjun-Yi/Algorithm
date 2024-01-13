import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
memos = {}
for _ in range(n):
  memos[input()] = 1

result = n
for _ in range(m):
  words = list(map(str, sys.stdin.readline().rstrip().split(',')))
  for w in words:
    if w in memos.keys():
      if memos[w] == 1:
        memos[w] -= 1
        result -= 1
  print(result)
