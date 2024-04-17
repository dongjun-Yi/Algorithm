import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        Map<String, Integer> map = new HashMap();
        
        for (String sk : skip.split("")){
            map.put(sk, 1);
        }
        
        for (String c : s.split("")){
            int count = index;
            int idx = 0;
            
            for (int i = 0; i < alpha.length(); i++){
                if (c.equals(String.valueOf(alpha.charAt(i)))){
                    idx = i;
                    break;
                }
            }

            while (count > 0) {
                idx++;
                count--;
                
                if(idx >= alpha.length())
                    idx = 0;
                
                if (map.containsKey(String.valueOf(alpha.charAt(idx)))){
                    count++;
                    continue;
                }   
            }
            
            if (idx == alpha.length())
                idx = 0;
            
            answer+= alpha.charAt(idx);
        }
        return answer;
    }
}