# 트럭에 태울 최대의 무게를 구하는 것으로, 여기서 어떤 바둑이들을 태워야 최대가 될지는 모르기 때문에 바둑이를 선택하는 방법의 모든 경우의 수를 구해야함.
import sys

c, n = map(int, input().split())

dogs = []
for _ in range(n):
  dogs.append(int(input()))

all_dogs_sum = sum(dogs)

res = -sys.maxsize


def dfs(L, sum, dogs_sum):
  global res
  global all_dogs_sum
  # 가지치기
  # 현재 레벨까지의 바둑이의 합과 앞으로의 바둑이까지의 합을 더했을때, res에 기록된 값
  # 보다 작을 때는 더 이상 탐색할 필요가 없으므로 return
  # 현재 레벨까지의 바둑이 몸무게 합 = 부분집합을 이용한 바둑이 선택 or 선택X
  # 앞으로의 바둑이까지의 합 = 모든 바둑이의 함 - 현재레벨까지 더한 바둑이의 몸무게
  if sum + (all_dogs_sum - dogs_sum) < res:
    return
  # 가지치기
  if sum > c:
    return
  if L == n:
    if res < sum:
      res = sum
  else:
    dfs(L + 1, sum + dogs[L], dogs_sum + dogs[L])
    dfs(L + 1, sum, dogs_sum + dogs[L])


dfs(0, 0, 0)
print(res)