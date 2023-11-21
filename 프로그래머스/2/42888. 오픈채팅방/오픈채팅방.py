def solution(record):
    answer = []
    chat_room = []
    chat_user = {}
    log = []
    
    for i in range(len(record)):
        r = record[i].split()
        io, uid = r[0], r[1]
        
        # 채팅방에 입장
        if io == 'Enter':
            chat_room.append((uid, "in"))
            chat_user[uid] = r[2]
        # 이름 변경
        elif io == 'Change':
            chat_user[uid] = r[2]
        # 채팅방 퇴장 기록
        else:
            chat_room.append((uid, "out"))
            
    for uid, io in chat_room:
        name = chat_user[uid]
        if io == "in":
            msg = name + "님이 들어왔습니다."
        else:
            msg = name + "님이 나갔습니다."
        answer.append(msg)
    return answer