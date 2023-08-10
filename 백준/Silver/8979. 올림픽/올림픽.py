n, k = map(int, input().split())

country = []
for _ in range(n):
  con, gold, silver, bronze = map(int, input().split())
  country.append((con, gold * 3, silver * 2, bronze * 1))

res = [0] * (n + 1)

for i in range(n):
  sum = country[i][1] + country[i][2] + country[i][3]
  res[country[i][0]] = sum

tmp = [0] * (n + 1)
for i in range(1, n + 1):
  rank = 1
  for j in range(1, n + 1):
    if res[i] < res[j]:
      rank += 1
  tmp[i] = rank

print(tmp[k])
