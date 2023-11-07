import sys

s = input()

n = s.count('a')

s += s[0:n - 1]

min_val = sys.maxsize

for i in range(len(s) - (n - 1)):
  min_val = min(min_val, s[i:i + n].count('b'))

print(min_val)
