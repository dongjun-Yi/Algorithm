import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayList<Character> LQ = new ArrayList(); // 선형 큐
        
        for(int i =0; i < s.length() + s.length(); i++){
            LQ.add(s.charAt(i % s.length()));
        }
        
        for(int i = 0; i < s.length(); i++){ 
            String tmp = "";
            for(int j = i; j < s.length() + i; j++){ // 회전 문자열 만들기
                tmp += LQ.get(j);
            }
            
            if(check(tmp))
                answer++;
        }
        return answer;
    }
    static boolean check(String tmp){
        Stack<Character> s = new Stack();
        
        for(int i = 0; i < tmp.length(); i++){
            char x = tmp.charAt(i);
            
            if(x == '(' || x == '[' || x == '{')
                s.add(x);
            else{
                if(s.isEmpty())
                    return false;
                
                char p = s.pop();
                if(x == ')' && p == '(')
                    continue;
                else if(x == ']' && p == '[')
                    continue;
                else if(x == '}' && p == '{')
                    continue;
                else
                    return false;
            }
        }
        
        if(!s.isEmpty()) // 비어있으면 올바른 괄호 문자열 X
            return false;
        return true;
    }
}