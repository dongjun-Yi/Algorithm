class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int c1 = 0;
        int c2 = 0;
        
        for(String s : goal){
            if(c1 < cards1.length && cards1[c1].equals(s)){
                c1++;
                continue;
            }
            else if(c2 < cards2.length && cards2[c2].equals(s)){
                c2++;
                continue;
            } else{
                return "No";
            }
        }
        return "Yes";
    }
}