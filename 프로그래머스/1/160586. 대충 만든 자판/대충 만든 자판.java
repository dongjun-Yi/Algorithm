import java.util.*;

class Solution {
    
    static Map<Character, Integer> map = new HashMap();
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        initMap(keymap);

        
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean flag = false;
            for(int j = 0; j < targets[i].length(); j++) {
                if(map.containsKey(targets[i].charAt(j))){
                    sum += map.get(targets[i].charAt(j));
                } else{
                    answer[i] = -1;
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;
            answer[i] = sum;
        }
        return answer;
    }
    
    static void initMap(String[] keymap) {
        for(String s : keymap){
            for(int i = 0; i <s.length(); i++){
                if (map.containsKey(s.charAt(i))){
                    if(map.get(s.charAt(i)) > (i + 1)){
                        map.put(s.charAt(i), i + 1);
                    }
                } else{
                    map.put(s.charAt(i), i + 1);
                }
            }
        }
    }
}