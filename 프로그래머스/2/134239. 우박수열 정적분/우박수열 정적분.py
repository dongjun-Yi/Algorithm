def get_ubak(k):
    result = [k]
    while k > 1:
        if k %2 == 0:
            k //= 2
        else:
            k = k *3 + 1
        result.append(k)
    
    return result

def solution(k, ranges):
    answer = []
    arr = get_ubak(k)
    n = len(arr) - 1

    for r in ranges:
        sum_value = 0
        x, y = r[0], r[1]
        
        if y <= 0:
            y = n + y
            
        if x > y:
            answer.append(-1)
            continue
        
        for i in range(x, y):
            if arr[i] < arr[i+1]:
                sum_value += arr[i]
                sum_value += (arr[i+1] - arr[i]) / 2
            elif arr[i] > arr[i+1]:
                sum_value += arr[i+1]
                sum_value += (arr[i] - arr[i+1]) / 2
            else:
                sum_value += arr[i]
                
        
        
        
        

        
        answer.append(sum_value)
            
    
    return answer