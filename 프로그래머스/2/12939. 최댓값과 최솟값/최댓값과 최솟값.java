import java.util.*;

class Solution {
    public String solution(String s) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;;
        for(String snum : s.split(" ")){
            maxValue = Math.max(maxValue, Integer.parseInt(snum));
            minValue = Math.min(minValue, Integer.parseInt(snum));
        }
        String answer = minValue + " " + maxValue;
        return answer;
    }
}