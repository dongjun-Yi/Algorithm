def solution(board):
    answer = -1
    o_cnt, x_cnt = 0, 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == 'O':
                o_cnt += 1
            elif board[i][j] == 'X':
                x_cnt += 1
                
    valid = o_cnt - x_cnt
    
    if valid not in [0,1]:
        return 0
    
    o_cnt, x_cnt = 0, 0
    
    for i in range(3):
        # 열
        if board[i][0] == board[i][1] == board[i][2]:
            if board[i][0] == 'O':
                o_cnt += 1
            if board[i][0] == 'X':
                x_cnt += 1
        # 행
        if board[0][i] == board[1][i] == board[2][i]:
            if board[0][i] == 'O':
                o_cnt += 1
            if board[0][i] == 'X':
                x_cnt += 1
    # 오른 대각선
    if board[0][0] == board[1][1] == board[2][2]:
        if board[1][1] == 'O':
            o_cnt += 1
        if board[1][1] == 'X':
            x_cnt += 1
            
    # 왼 대각선
    if board[0][2] == board[1][1] == board[2][0]:
        if board[1][1] == 'O':
            o_cnt += 1
        if board[1][1] == 'X':
            x_cnt += 1

    if o_cnt and x_cnt:
        return 0
    if o_cnt == 1 and valid == 0:
        return 0
    if x_cnt == 1 and valid >= 1:
        return 0
    return 1