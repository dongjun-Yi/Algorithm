# decision algorithm
# 주어진 범위내에서 만족하는 최적의 해를 찾아나감.
# 1. 주어진 범위에서 중앙값을 찾은 후 이 값을 기준으로 답을 만족 or 만족안하는지
# 2. 만족하면 탐색범위를 절반으로 줄여서 더 좋은 해답을 찾기 위해 탐색한다.
n, c = map(int, input().split())

mag = []

for _ in range(n):
  mag.append(int(input()))

mag.sort()

lt = 1
rt = max(mag)


# 마구간에 c마리를 배치할 수 있는지 체크하는 함수
# 마구간에 말을 배치할 수 있는 마리수 반환
def check_mag(mid):
  cur = mag[0]
  cnt = 1
  for i in range(1, len(mag)):
    if mag[i] - cur < mid:
      continue
    cnt += 1
    cur = mag[i]
  return cnt


res = 0
while lt <= rt:
  mid = (lt + rt) // 2
  # 답을 만족한다면 lt값을 중앙값 + 1하여 탐색범위를 반으로 좁힙
  if check_mag(mid) >= c:
    res = mid
    lt = mid + 1
  # 답을 만족안하면 rt값을 중앙값 -1 하여 탐색번위를 반으로 좁힙
  else:
    rt = mid - 1

print(res)
