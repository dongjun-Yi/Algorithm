import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet();
        int[] LQ = new int[elements.length + elements.length];
        
        for(int i = 0; i < LQ.length; i++){
            LQ[i] = elements[i % elements.length];
        }
        
        for(int i = 1; i <= elements.length; i++){
            for(int j = 0; j < elements.length; j++){
                int sum = 0;
                for(int k = 0; k < i; k++){
                    sum += LQ[k + j];
                }
                answer.add(sum);
            }
        }
        return answer.size();
    }
}