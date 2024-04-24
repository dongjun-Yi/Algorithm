import java.util.*;

class Solution {
    public String[] solution(String myString) {
        ArrayList<String> list = new ArrayList(); 
        
        for (String s : myString.split("x")){
            if (s.equals(""))
                continue;
            list.add(s);
        }
        
        Collections.sort(list);

        String[] answer = list.toArray(new String[0]); // 길이를 0으로 지정하여 생성자를 넘겨주면 자동으로 원본 size의 배열을 생성해줌.
        return answer;
    }
}