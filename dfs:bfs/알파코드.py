code = list(map(int, input()))
n = len(code)
code.insert(n, -1)
res = [0] * (n + 3)

cnt = 0


def dfs(L, p):
  global cnt
  if L == n:
    cnt += 1
    for j in range(p):
      # 대문자로 출력
      print(chr(res[j] + 64), end='')
    print()
  else:
    for i in range(1, 27):
      if code[L] == i:
        res[p] = i
        dfs(L + 1, p + 1)
      # 두자리 확인, L번째는 i의 십의 자리, L+1은 i의 일의 자리
      elif i >= 10 and code[L] == i // 10 and code[L + 1] == i % 10:
        res[p] = i
        dfs(L + 2, p + 1)


dfs(0, 0)
print(cnt)