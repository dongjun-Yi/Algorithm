class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_cnt = 0;
        int y_cnt = 0;

        for (int i = 0; i< s.length();i++){
            char c = s.toLowerCase().charAt(i);
            if (c == 'p'){
                p_cnt++;
            } else if (c =='y') {
                y_cnt++;
            }
        }
        
        if (p_cnt == y_cnt)
            return true;
        
        return false;
    }
}