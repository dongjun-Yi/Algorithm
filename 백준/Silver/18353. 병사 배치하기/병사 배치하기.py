n = int(input())
arr = list(map(int, input().split()))
arr.reverse()
d = [1] * (n + 1)

for i in range(1, n):
  for j in range(i):
    if arr[j] < arr[i]:
      d[i] = max(d[i], d[j] + 1)

print(n - max(d))
