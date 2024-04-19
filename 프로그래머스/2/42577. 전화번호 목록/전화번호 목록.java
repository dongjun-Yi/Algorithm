import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap();
        
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        
        for(String phone : phone_book){
            String compare = "";
            for(String c : phone.split("")){
                compare += c;
                if (map.containsKey(compare))
                    return false;
            }
            map.put(phone, 1);
        }
        return true;
    }
}