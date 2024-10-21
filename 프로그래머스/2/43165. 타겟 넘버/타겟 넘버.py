res = 0

def dfs(L, sum, target, numbers):
    global res
    if L == len(numbers):
        if sum == target:
            res += 1
        return
    dfs(L+1, sum + numbers[L], target, numbers)
    dfs(L+1, sum - numbers[L], target, numbers)
    
def solution(numbers, target):
    dfs(0, 0, target, numbers)
    return res