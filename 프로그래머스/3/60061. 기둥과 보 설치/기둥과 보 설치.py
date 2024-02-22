def check(answer):
    KIDOONG = 0
    BO = 1
    
    for x, y, stuff in answer:
        if stuff == KIDOONG: # 1. 바닥 or 보의 한쪽 끝부분 위 or 기둥 위
            if y == 0 or [x-1, y, 1] in answer or [x,y,1] in answer or [x,y-1,0] in answer:
                continue
            return False
        
        elif stuff == BO: # 끝 부분이 기둥위일 때 or 양쪽이 보로 연결되어 있을 때
            if [x, y-1, 0] in answer or [x+1, y-1, 0] in answer or ([x-1, y, 1] in answer and [x+1,y, 1] in answer):
                continue
            return False
    return True
    
def solution(n, build_frame):
    answer = []

    install = 1
    remove = 0
    
    for b in build_frame:
        x, y, stuff, op = b
        
        if op == install: # 설치
            answer.append([x, y, stuff])
            if not check(answer): 
                answer.remove([x, y, stuff])
                
        if op == remove: # 제거
            answer.remove([x, y, stuff])
            if not check(answer): 
                answer.append([x, y, stuff])

    return sorted(answer)