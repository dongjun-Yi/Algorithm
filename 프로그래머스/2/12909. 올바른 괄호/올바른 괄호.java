import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack();
        for(String c : s.split("")){
            if(c.equals("("))
                stack.add(c);
            else{
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        
        if(!stack.isEmpty())
            return false;
        return true;
    }
}