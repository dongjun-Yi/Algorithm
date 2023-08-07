n = int(input())
arr = list()

for _ in range(n):
  x, y = map(int, input().split())
  arr.append((x, y))

for i in range(n):
  rank = 1
  for j in range(n):
    if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
      rank += 1
  print(rank, end=' ')