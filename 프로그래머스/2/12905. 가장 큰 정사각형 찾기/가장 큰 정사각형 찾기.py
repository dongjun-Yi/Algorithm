def solution(board):
    answer = 0 
    row, col = len(board), len(board[0])
    
    dp = [[0] * col for _ in range(row)]
    dp[0] = board[0]
    
    for i in range(1, row):
        dp[i][0] = board[i][0]
    
    for i in range(1, row):
        for j in range(1, col):
            if board[i][j] == 1:
                dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
    
    for x in dp:
        answer = max(answer, max(x))
    
    return answer ** 2 