s = input()
sum = int(s[0])

for i in range(1, len(s)):
  cur = int(s[i])
  if sum * cur > sum + cur:
    sum *=cur
  else:
    sum += cur

print(sum)