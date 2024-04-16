import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for (int i = 0; i < X.length(); i++){
            xCount[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++){
            yCount[Y.charAt(i) - '0']++;
        }
        
        for (int i = 9; i > -1; i--){
            while (xCount[i] > 0 && yCount[i] > 0){
                answer.append(i);
                xCount[i]--;
                yCount[i]--;
            }       
        }
        
        if (answer.toString().equals(""))
            return "-1";
        if (answer.toString().substring(0, 1).equals("0"))
            return "0";
        
        return answer.toString();
    }
}