import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {

        Arrays.sort(A);
        Arrays.sort(B);
        
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        
        int sum = 0;
        for(int i = 0; i < B.length; i++){
            sum += B[i] * A[A.length - i - 1];
        }
        
        return sum;
    }
}