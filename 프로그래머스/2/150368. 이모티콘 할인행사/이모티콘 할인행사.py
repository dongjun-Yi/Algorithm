def solution(users, emoticons):
    answer = [0, 0]
    
    ratio_data = [10, 20, 30, 40]
    discount = []
    
    def dfs(L, arr):
        if L == len(arr):
            discount.append(arr[:])
            return
        else:
            for d in ratio_data:
                arr[L] += d
                dfs(L+1, arr)
                arr[L] -= d
    
    dfs(0, [0] * len(emoticons))

    for d in range(len(discount)):
        plus_user = 0
        total = 0
        
        for user in users:
            ratio, limit_price = user
            emoticon_buy = 0 
            
            for i in range(len(emoticons)):
                if ratio <= discount[d][i]:
                    emoticon_buy += emoticons[i] * ((100 - discount[d][i]) / 100)
            
            if limit_price <= emoticon_buy:
                plus_user += 1
            else:
                total += emoticon_buy
        
        if answer[0] < plus_user:
            answer = [plus_user, total]
        elif answer[0] == plus_user:
            if answer[1] < total:
                answer = [plus_user, total]
                
    return answer