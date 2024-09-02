import sys

s, p = map(int, sys.stdin.readline().split())

dna = sys.stdin.readline()

acgt = list(map(int, sys.stdin.readline().split()))


def check(s):
  for i in range(4):
    if s[i] < acgt[i]:
      return False
  return True


def add(c):
  if c == 'A':
    count[0] += 1
  elif c == 'C':
    count[1] += 1
  elif c == 'G':
    count[2] += 1
  else:
    count[3] += 1


def remove(c):
  if c == 'A':
    count[0] -= 1
  elif c == 'C':
    count[1] -= 1
  elif c == 'G':
    count[2] -= 1
  else:
    count[3] -= 1


count = [0] * 4
result = 0

for i in range(0, p):
  add(dna[i])
if check(count):
  result += 1

for i in range(p, s):
  add(dna[i])
  remove(dna[i - p])

  if check(count):
    result += 1

print(result)
