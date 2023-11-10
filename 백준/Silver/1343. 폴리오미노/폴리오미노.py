import sys

s = input()

res = []


# 폴리오미노 만드는 함수
# 만약 매개변수 cnt가 2나 4로 안나눠지면 폴리오미노를 만들 수 없으므로 -1 return
def makePoli(cnt):
  global res
  tmp = ""
  if cnt == 0:
    return
  if cnt % 2 == 0:
    while cnt > 0:
      if cnt % 4 == 0:
        tmp += "AAAA"
        cnt -= 4
      elif cnt % 2 == 0:
        tmp += "BB"
        cnt -= 2
    res.append(tmp)
  else:
    print(-1)
    sys.exit(0)


# 폴리오미노를 만들 자릿수 count
flag = 0
for x in s:
  if x == 'X':
    flag += 1
  else:
    makePoli(flag)
    flag = 0
    res.append(".")

# '.'을 안만나고 flag가 0이 아닌 상태로 있다면 폴리오미노 만들기
if flag:
  makePoli(flag)

# 알파벳 사전순으로 출력하기 위한 구문
ans = []
for x in res:
  a = sorted(list(x))
  tmp = ""
  for t in a:
    tmp += str(t)
  ans.append(tmp)

tmp = ""
for x in ans:
  tmp += x

print(tmp)
