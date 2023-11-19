import math
def solution(fees, records):
    answer = []
    # 주차장에 입장한 차량 딕셔너리
    cars = {}
    # 주차장 IN, OUT해서 계산한 시간
    park_times = {}
    for r in records:
        time, car_num, io = r.split()
        if io == 'IN':
            cars[car_num] = time
            if car_num not in park_times:
                park_times[car_num] = 0
        else:
            # 시간 계산
            time1 = cars.get(car_num)
            del cars[car_num]
            
            h1,m1 = time1.split(":")
            if h1[0] == '0':
                h1 = h1[1]
                
            time2 = time
            h2,m2 = time2.split(":")
            if h2[0] == '0':
                h2 = h2[1]
            h = int(h2)-int(h1)
            m = int(m2)-int(m1)
            pay_time = h * 60 + m
            park_times[car_num] +=  pay_time
    # 만약 OUT을 안했을 경우 23:59에 출고한거로 계산
    if cars:
        for car_num,time in cars.items():
            h1,m1 = time.split(":")
            if h1[0] == '0':
                h1 = h1[1]
            h = 23 - int(h1)
            m = 59 - int(m1)
            pay_time = h * 60 + m
            park_times[car_num] +=  pay_time
        
    # 요금 계산
    for k,v in park_times.items():
        # 기본시간 미만동안 사용
        money = fees[1]
        # 기본시간을 초과한 경우
        if v > fees[0]:
            tmp = (v - fees[0]) / fees[2]
            # 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면 올림
            if tmp % fees[2] !=0:
                tmp = math.ceil(tmp)
                
            money += tmp * fees[3]
        
        answer.append((k, money))
    # 차량번호가 작은 자동차부터
    answer.sort(key = lambda x : x[0])
    
    res = []
    
    for x,y in answer:
        res.append(y)
        
    return res