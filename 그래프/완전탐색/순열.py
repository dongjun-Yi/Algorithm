n, m = map(int, input().split())

res = [0] * m
# 중복을 허락하지 않도록 check변수로 처리
ch = [0] * (n + 1)

cnt = 0


def dfs(L):
  global cnt
  if L == m:
    for x in res:
      print(x, end=' ')
    print()
    cnt += 1
  else:
    for i in range(1, n + 1):
      if not ch[i]:
        res[L] = i
        ch[i] = 1
        dfs(L + 1)
        ch[i] = 0


dfs(0)
print(cnt)
