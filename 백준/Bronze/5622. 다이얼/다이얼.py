alpabet_list = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
word = input()

count = 0

for i in alpabet_list:
  for j in word:
    if j in i:
      count += alpabet_list.index(i) + 3

print(count)