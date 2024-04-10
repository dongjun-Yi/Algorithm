import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length(); i++) {
            String target = s.substring(0, i);
            String result = "";
            int count = 1;
            
            for (int j = i; j <= s.length(); j= j + i) {
                int endIndex = Math.min(j+i, s.length());
                String temp = s.substring(j, endIndex);
                
                if (target.equals(temp)){
                    count++;
                } else{
                    if (count > 1){
                        result += String.valueOf(count);
                    }
                    result += target;
                    target = temp;
                    count = 1;
                }
            }
            result += target;
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}