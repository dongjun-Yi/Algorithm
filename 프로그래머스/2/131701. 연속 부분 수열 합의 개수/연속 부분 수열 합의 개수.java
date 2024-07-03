import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<Integer>();
        int length = elements.length;
        int[] lq = new int[length + length];
        
        
        for(int i = 0; i < lq.length; i++){
            lq[i] = elements[i % length];
        }

        for(int i = 1; i <= length; i++){
            for (int j = 0; j < length; j++){
                int sum = 0;
                for(int k = 0; k < i; k++){
                    sum += lq[k + j];
                }
                answer.add(sum);
            }
        }
        return answer.size();
    }
}