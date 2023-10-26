def solution(players, callings):
    # key : 선수이름, value : 등수로 딕셔너리 초기화
    player_dict = {player:idx for idx, player in enumerate(players)}
    
    for c in callings:
        idx = player_dict[c]
        players[idx], players[idx- 1] = players[idx-1], players[idx]
        
        player_dict[players[idx]] = idx
        player_dict[players[idx-1]] = idx -1
                
    
    return players