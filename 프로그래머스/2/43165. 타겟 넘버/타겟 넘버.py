def dfs(L, sum, numbers, target):
    global cnt
    
    if L == len(numbers) and sum == target:
        cnt +=1
    elif L >= len(numbers):
        return
    else:
        dfs(L+1, sum + numbers[L], numbers, target)
        dfs(L+1, sum - numbers[L], numbers, target)
cnt = 0

def solution(numbers, target):
    dfs(0,0, numbers, target)
    print(cnt)
    return cnt