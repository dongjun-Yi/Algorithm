n = int(input())
arr = list(map(int, input().split()))

arr.sort()
result = 0

group_member_cnt = 0
for i in range(len(arr)):
  group_member_cnt +=1
  if group_member_cnt >= i:
    result +=1
    group_member_cnt = 0
print(result)
