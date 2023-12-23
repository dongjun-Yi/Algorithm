import sys
n = int(input())
coins = []
people = [0] * 3
for _ in range(n):
  coins.append(int(input()))

# L은 동전리스트의 인덱스
def dfs(L):
  global res
  if L == n:
    tmp = max(people) - min(people)
    if tmp < res:
      # 세 사람의 금액이 다른것을 set을 이용해 체크
      cnt = set()
      for x in people:
        cnt.add(x)
      if len(cnt) ==3:
        res = tmp
  else:
    for i in range(len(people)):
      people[i] +=coins[L]
      dfs(L+1)
      people[i] -=coins[L]

res = sys.maxsize
dfs(0)
print(res)