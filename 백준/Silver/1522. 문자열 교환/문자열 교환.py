# 슬라이딩 윈도우 언제 사용?
#-> 1. 부분 문자열 또는 부분 배열을 대상으로 하는 최소, 최대, 합 등과 같은 연산을 수행할 때.
# 2. 고정 크기의 윈도우 내에서 유효한 조건을 충족하는 연속된 데이터를 찾을 때.
# 3. 슬라이딩 윈도우를 사용하여 두 개의 배열 또는 문자열 사이의 연속성을 비교하고 유사도를 계산할 때.
import sys

s = input()

n = s.count('a')

s += s[0:n - 1]

min_val = sys.maxsize

for i in range(len(s) - (n - 1)):
  min_val = min(min_val, s[i:i + n].count('b'))

print(min_val)
