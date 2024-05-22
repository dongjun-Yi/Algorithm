import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap();
    
    public int solution(String[] babbling) {
        int answer = 0;
        initMap();
        
        for(String str : babbling){
            String tmp = "";
            int length = str.length();
            String checkString = "";
            
            for(String s : str.split("")){
                tmp += s;
                
                for(String key : map.keySet()){
                    if (tmp.equals(key)){
                        if(tmp.length() == length && (!tmp.equals(checkString))){
                            answer++;
                            break;
                        } else{
                            length -= tmp.length();
                            if(tmp.equals(checkString))
                                break;
                            checkString = tmp;
                            tmp = "";
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    static void initMap(){
        map.put("aya", 1);
        map.put("ye", 1);
        map.put("woo", 1);
        map.put("ma", 1);   
    }
}