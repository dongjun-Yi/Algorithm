n = int(input())
f = [0] * 41


def fib(n):
  if n == 1 or n == 2:
    return 1
  else:
    return fib(n - 1) + fib(n - 2)


def fibonacci(n):
  f[1] = f[2] = 1
  cnt = 0
  for i in range(3, n + 1):
    f[i] = f[i - 1] + f[i - 2]
    cnt += 1
  return cnt


print(fib(n), fibonacci(n))
