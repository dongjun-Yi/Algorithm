def check(answer):
    for x, y, frame in answer:
        if frame == 0: # 기둥 조건
            if y == 0 or [x-1, y, 1] in answer or [x, y, 1] in answer or [x, y-1, 0] in answer:
                continue
            else:
                return False
        if frame == 1: # 보 조건
            if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1, y, 1] in answer):
                continue
            else:
                return False
    return True

def solution(n, build_frame):
    answer = []
    
    for b in build_frame:
        x, y, frame, op = b
        
        if op == 0: # 삭제
            answer.remove([x,y,frame])
            if not check(answer): # 삭제한 경우에 조건에 위배되면 다시 삽입
                answer.append([x,y,frame])
        if op == 1:
            answer.append([x,y,frame])
            if not check(answer):
                answer.remove([x,y,frame])
                
    return sorted(answer)