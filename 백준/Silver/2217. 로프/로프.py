n = int(input())
lopes = []
for _ in range(n):
  lopes.append(int(input()))

lopes.sort(reverse=True)

ans = []
for i in range(n):
  ans.append(lopes[i] * (i + 1))

print(max(ans))