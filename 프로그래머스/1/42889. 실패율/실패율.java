import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double length = stages.length;
        ArrayList<Info> list = new ArrayList();
        
        for (int i = 1; i<=N; i++){ // stage 단계
            double cnt = 0;
            for (int j = 0; j < stages.length; j++){
                if (stages[j] == i)
                    cnt++;
            }
            if (cnt == 0)
                list.add(new Info(0, i));
            else
                list.add(new Info((cnt/length), i));
            length -= cnt;
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i).index;
        
        return answer;
    }
}

class Info implements Comparable<Info>{
    double failure;
    int index;
    
    public Info(double failure, int index){
        this.failure = failure;
        this.index = index;
    }
    
    public int compareTo(Info o){
        if (this.failure == o.failure)
            return this.index - o.index;
        return Double.compare(o.failure, this.failure);
    }
}