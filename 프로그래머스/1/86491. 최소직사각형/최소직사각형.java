import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0; 
        
        int[] maxArr = new int[sizes.length];
        int[] minArr = new int[sizes.length];
        
        int max_length = 0;
        for (int i = 0; i < sizes.length; i++){
            if (sizes[i][0] < sizes[i][1]){
                minArr[i] = sizes[i][0];
                maxArr[i] = sizes[i][1];
            } else{
                minArr[i] = sizes[i][1];
                maxArr[i] = sizes[i][0];
            }
        }
        
        for (int x : minArr){
            min = Math.max(min, x);
        }
        
        for (int x : maxArr){
            max = Math.max(max, x);
        }
        
        return max * min;
    }
}