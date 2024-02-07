import heapq

def num(s):
    return int(s[:2]) * 60 + int(s[3:])
    

def solution(book_time):

    book_time.sort(key=lambda x : x[0])
    room = []
    
    for book in book_time: # O(n * logn)
        start = num(book[0])
        end = num(book[1]) + 10
        if room and room[0] <= start:
            heapq.heappop(room)
        heapq.heappush(room, end)
        
    return len(room)