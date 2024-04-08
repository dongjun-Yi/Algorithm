import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap();
        
        for (int i = 0; i< players.length; i++){
            map.put(players[i], i);
        }
        
        for (int i = 0; i< callings.length; i++){
            String name = callings[i];
            int index = map.get(name);
            
            String temp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = temp;
            
            map.put(name, index-1);
            map.put(temp, index);
        }
        return players;
    }   
}