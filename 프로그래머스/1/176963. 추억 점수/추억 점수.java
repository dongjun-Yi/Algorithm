import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap();
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        initMap(name, yearning);
        
        for(int i = 0; i < photo.length; i++){
            int sum = 0;
            for(String s : photo[i]){
                if(map.containsKey(s)){
                    sum += map.get(s);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
    
    static void initMap(String[] name, int[] yearning) {
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
    }
}