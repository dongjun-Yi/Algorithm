import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        for (int i = 0 ; i < t.length() - length + 1; i++){
            String temp = t.substring(i, i + length);
            Long tempInt = Long.parseLong(temp);

            if (tempInt <= Long.parseLong(p))
                answer++;
        }
        return answer;
    }
}