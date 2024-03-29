n = int(input())

arr = []
for _ in range(n):
  arr.append(list(map(int, input().split())))

for i in range(1, n):
  # 빨간색
  arr[i][0] = min(arr[i - 1][1], arr[i - 1][2]) + arr[i][0]
  # 초록색
  arr[i][1] = min(arr[i - 1][0], arr[i - 1][2]) + arr[i][1]
  # 파란색
  arr[i][2] = min(arr[i - 1][0], arr[i - 1][1]) + arr[i][2]

print(min(arr[n - 1]))
