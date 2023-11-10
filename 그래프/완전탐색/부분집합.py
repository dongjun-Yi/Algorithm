n = int(input())

res = [0] * (n + 1)


def dfs(L):
  # 트리의 레벨이 입력받은 숫자면 res 리스트에 있는 요소 출력
  if L == n:
    for x in res:
      if x != 0:
        print(x, end=' ')
    return
  else:
    res[L] = L + 1
    dfs(L + 1)
    # 순회 후 다시 0 으로
    res[L] = 0
    dfs(L + 1)


dfs(0)
