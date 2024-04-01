from itertools import permutations

def solution(users, emoticons):
    answer = [0, 0]
    discount_ratio = [10, 20, 30, 40]
    discount = []
    
    def dfs(L, arr):
        if L == len(emoticons):
            discount.append(arr[:])
        else:
            for d in discount_ratio:
                arr[L] = d
                dfs(L+1, arr)
                arr[L] = d
    
    dfs(0, [0] * len(emoticons))

    # discount = list(permutations(discount_ratio, len(emoticons))) => 순열로는 중복순열의 형태로 경우의수를 못구하기 때문에 dfs로 할인율 경우의수 계산

    
    for d in range(len(discount)):
        plus_service = 0
        total = 0
        
        for user in users:
            emoticon_pay = 0
            ratio, limit_price = user
            
            for i in range(len(emoticons)):
                if ratio <= discount[d][i]:
                    emoticon_pay += emoticons[i] - (emoticons[i] * discount[d][i] * 0.01)
            
            if limit_price <= emoticon_pay:
                plus_service += 1
            else:
                total += emoticon_pay
            
        if answer[0] < plus_service:
            answer = [plus_service, total]
        elif answer[0] == plus_service:
            if answer[1] < total:
                answer = [plus_service, total]
    return answer