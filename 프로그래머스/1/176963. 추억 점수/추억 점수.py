def solution(name, yearning, photo):
    answer = []
    for points in photo:
        sum = 0
        for p in points:
            if p not in name:
                continue
            idx = name.index(p)
            sum +=yearning[idx]
        answer.append(sum)
    return answer