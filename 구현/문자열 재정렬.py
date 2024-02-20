# s<=10^4 이므로 시간복잡도 O(nlogn)으로 설계
s = input()
sum = 0
alpha = []

for x in s:  # O(n)
  if x.isdecimal():
    sum += int(x)
  else:
    alpha.append(x)

alpha.sort()  # O(nlogn)

print(''.join(alpha) + str(sum))
