def solution(record):
    answer = []
    user_info = {}
    
    for rec in record:
        r = rec.split(" ")
        command, id = r[0], r[1]
        if command != 'Leave':
            user_info[r[1]] = r[2]
    
    
    for rec in record:
        r = rec.split(" ")
        command, id = r[0], r[1]
        
        if id in user_info.keys():
            if command == 'Leave':
                answer.append((id, 'Leave'))

            else:            
                user_info[id] = r[2]
                if command == 'Enter':
                    answer.append((id, 'Enter'))
                continue
                
    result = []
    for id, command in answer:
        if command == 'Enter':
            result.append(user_info[id] + "님이 들어왔습니다.")
        else:
            result.append(user_info[id] + "님이 나갔습니다.")
        
    return result