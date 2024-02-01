# 입력 p와 n의 입력 수가 10^5이므로 시간복잡도를 O(n) 이하로 설계해야함.
# 그래서 sort()는 사용 안하고 구현

from collections import deque

T = int(input())
for _ in range(T):
  p = input()
  n = int(input())
  array = input()

  x = deque()
  tmp = ''
  for a in array:
    if a.isdecimal():
      tmp += a
    if a == ',' or a == ']':
      if tmp.isdecimal():
        x.append(int(tmp))
        tmp = ''
  op_R_count_check = 0

  for op in p:
    if op == 'D':
      if len(x) == 0:
        print("error")
        break
      if op_R_count_check == 1:
        x.pop()
      else:
        x.popleft()

    if op == 'R':  # R 개수 count
      op_R_count_check += 1
      if op_R_count_check == 2:
        op_R_count_check = 0
  else:  # for op in p:
    print("[", end='')
    if op_R_count_check == 1:
      for i in range(len(x) - 1, -1, -1):
        if i == 0:
          print(x[i], end='')
          break
        print(x[i], end=',')
    else:
      for i in range(len(x)):
        if i == len(x) - 1:
          print(x[i], end='')
          break
        print(x[i], end=',')
    print("]")
