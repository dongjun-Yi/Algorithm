from collections import deque

def solution(s):
    answer = 0
    s= list(s)
    x = 0
    while x < len(s):
        stack = []
        flag = False
        for i in range(len(s)):
            if s[i] == '[' or s[i] == '(' or s[i] == '{':
                stack.append(s[i])
            else:
                if stack:
                    if stack[-1] == '[' and s[i] == ']':
                        stack.pop()
                        flag = True
                    elif stack[-1] == '(' and s[i] == ')':
                        stack.pop()
                        flag = True
                    elif stack[-1] == '{' and s[i] == '}':
                        stack.pop()
                        flag = True
        if flag and not stack:
            answer +=1
        x+=1
        s.append(s.pop(0))
        
    return answer