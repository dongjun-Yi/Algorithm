import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap();
        
        for (int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        int n = nums.length / 2;
        
        for (int x : map.keySet()){
            if (n <= answer)
                return n;
            answer++;
        }
        return answer;
    }
}