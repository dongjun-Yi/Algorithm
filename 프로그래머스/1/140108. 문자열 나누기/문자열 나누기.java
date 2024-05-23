class Solution {
    public int solution(String s) {
        int answer = 0;
        String x = String.valueOf(s.charAt(0));
        String notX = "";
        
        for(int i = 1; i< s.length();i++) {
            if(x.length() == 0 || x.charAt(0) == s.charAt(i)){
                x += String.valueOf(s.charAt(i));
                continue;
            } else{
                notX += String.valueOf(s.charAt(i));
                if(x.length() == notX.length()){
                    answer++;
                    x = "";
                    notX = "";
                }
            }
        }
        
        if(x.length() > 0) // 4
            answer++;
        return answer;
    }
}