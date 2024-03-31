def convert_time(s):
    hour, time = map(int, s.split(":"))
    return hour * 60 + time

def solution(plans):
    answer = []
    new_plans = []
    for name, start, playtime in plans:    
        new_plans.append((name, convert_time(start), int(playtime)))

    new_plans.sort(key = lambda x: x[1])
    time = 0
    homework = [] # 선입후출 : 스택 자료구조 이용
    
    for i in range(len(new_plans)):
        name, start, playtime = new_plans[i]

        while homework:
            h_name, h_playtime = homework.pop()

            if time >= h_playtime:
                answer.append(h_name)
                time -= h_playtime
            else:
                homework.append((h_name, h_playtime - time))
                break

        homework.append((name, playtime))

        if i < len(new_plans) - 1:
            next = new_plans[i+1][1]
            time = next - start
                
    while homework:
        name = homework.pop()[0]
        answer.append(name)
    
    return answer