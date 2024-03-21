def solution(n):
    answer = []
    def hanoi(src, dest, mid, n):
        if n == 1:
            answer.append([src, dest])
        else:
            hanoi(src, mid, dest, n-1)
            hanoi(src, dest, mid, 1)
            hanoi(mid, dest, src, n-1)
    hanoi(1, 3, 2, n)
    return answer