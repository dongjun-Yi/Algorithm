import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> xmap = new HashMap();
        Map<Integer, Integer> ymap = new HashMap();
        
        
        for(String x : X.split("")) {
            int key = Integer.parseInt(x);
            xmap.put(key, xmap.getOrDefault(key, 0) + 1);
        }
        
        for(String y : Y.split("")) {
            int key = Integer.parseInt(y);
            ymap.put(key, ymap.getOrDefault(key, 0) + 1);
        }
        
        for (int i = 9; i >=0; i--) {
            if (xmap.containsKey(i) && ymap.containsKey(i)){
                while(xmap.get(i) != 0 && ymap.get(i) !=0){
                    answer.append(i);
                    xmap.put(i, xmap.get(i) - 1);
                    ymap.put(i, ymap.get(i) - 1);
                }
            }
        }
        
        if (answer.toString().equals(""))
            return "-1";
        
        if (answer.toString().charAt(0) == '0')
            return "0";
        
        return answer.toString();
        
    }
}