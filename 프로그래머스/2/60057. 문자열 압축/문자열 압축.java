import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        int count = 1;
        
        for (int i = 1; i <= n / 2; i++){
            StringBuffer result = new StringBuffer();
            String target = s.substring(0, i);
            
            for (int j = i; j <= n; j= j + i){ // 3abcdede
                
                int endIndex = Math.min(j + i, n);
                String temp = s.substring(j, endIndex);
                
                if (target.equals(temp))
                    count++;
                else {
                    if (count > 1){
                        result.append(count);
                    }
                    result.append(target);
                    count = 1;
                    target = temp;
                }
            }
            result.append(target);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}