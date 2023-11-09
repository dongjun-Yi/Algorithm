n = int(input())
meeting = []

for _ in range(n):
  s, e = map(int, input().split())
  meeting.append((s, e))

# 회의가 끝나는 시간으로 정렬
meeting.sort(key=lambda x: (x[1], x[0]))

end_time = 0
cnt = 0

for start, end in meeting:
  if start >= end_time:
    end_time = end
    cnt += 1

print(cnt)