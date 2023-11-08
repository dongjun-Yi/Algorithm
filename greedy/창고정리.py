l = int(input())

arr = list(map(int, input().split()))

m = int(input())

# 그리디는 가장 큰, 가장 작은 같은 기준을 제시해주므로 정렬 알고리즘 생각
for _ in range(m):
  arr[0] += 1
  arr[l - 1] -= 1
  arr.sort()

print(arr[l - 1] - arr[0])
