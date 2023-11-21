# 투포인터
import sys

def solution(gems):
    answer = [0, len(gems)]
    size = len(set(gems))
    left, right = 0,0
    gem_dict = {gems[0] : 1}
    
    # 투 포인터가 범위를 벗어나면 무한루프 종료
    while left < len(gems) and right < len(gems):
        # 딕셔너리에 보석 종류가 다 들어오는 경우
        if len(gem_dict) == size:
            # 최소 크기 확인
            if (right - left) < (answer[1] - answer[0]):
                answer = [left, right]
            # left 포인터 인덱스 늘리면서 딕셔너리에 빈도수가 0이면 삭제
            else:
                gem_dict[gems[left]] -=1
                if gem_dict[gems[left]] == 0:
                    del gem_dict[gems[left]]
                left +=1
        else:
            right+=1
            
            if right == len(gems):
                break
            if gems[right] in gem_dict:
                gem_dict[gems[right]] +=1
            else:
                gem_dict[gems[right]] = 1
        
    return [answer[0] +1, answer[1] + 1]