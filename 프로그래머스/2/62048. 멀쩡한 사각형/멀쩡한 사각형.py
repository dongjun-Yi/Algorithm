import math
def solution(w,h):
    # 전체 사각형의 개수 - (가로 + 세로 - 최대 공약수)
    # 최대 공약수는 대각선이 지나가는 사각형의 수
    # 그래서 사용할 수 있는 대각선의 수는 (가로 + 세로 - 최대공약수)
    return w*h - (w+h-math.gcd(w,h))