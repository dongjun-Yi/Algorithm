import sys

T = int(input())

for _ in range(T):
  w = input()
  k = int(input())

  d = {}
  min_length = sys.maxsize
  max_length = -sys.maxsize
  not_found = True

  for i in range(len(w)):
    if w[i] in d:
      d[w[i]].append(i)
    else:
      d[w[i]] = [i]

  for key, index_array in d.items():
    start = 0
    end = start + k - 1

    if len(index_array) < k:
      continue

    while end < len(index_array):
      not_found = False
      length = index_array[end] - index_array[start] + 1
      min_length = min(min_length, length)
      max_length = max(max_length, length)
      start += 1
      end += 1

  if not_found:
    print(-1)
  else:
    print(min_length, max_length)
