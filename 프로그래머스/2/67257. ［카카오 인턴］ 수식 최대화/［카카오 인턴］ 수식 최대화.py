from itertools import permutations

def operation(a,b, op):
    if op == '+':
        return str(int(a) + int(b))
    if op == '-':
        return str(int(a) - int(b))
    if op == '*':
        return str(int(a) * int(b))
    
    
def calculate(exp, op):
    # 숫자와 연산자를 분리하여 s 배열에 담음
    s = []
    tmp = ''
    for e in exp:
        if e.isdigit():
            tmp+=e
        else:
            s.append(tmp)
            s.append(e)
            tmp=''
    # 마지막 숫자 삽입
    s.append(tmp)

    for o in op:
        stack = []
        while len(s) !=0:
            # 첫번째 원소 꺼냄
            cur = s.pop(0)
            # 만약 꺼낸 원소가 연산자라면 계산
            if cur == o:    
                stack.append((operation(stack.pop(), s.pop(0), o)))
            else:
                stack.append(cur)
        s= stack
    return abs(int(s[0]))
    
def solution(expression):
    op = ['+', '-', '*']
    # 리스트 원소 중 3개를 뽑아 순열을 만든 리스트
    op = list(permutations(op,3))
    answer = []
    for o in op:
        answer.append(calculate(expression, o))
    return max(answer)