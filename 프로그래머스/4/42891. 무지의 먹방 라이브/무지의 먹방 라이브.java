import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        long sum = 0;
        
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        
        if (sum <= k)
            return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue();
        for (int i = 0; i < food_times.length; i++){
            pq.offer(new Food(food_times[i], i + 1));
        }
        
        sum = 0;
        long time = 0; // 먹은 음식 시간
        long length = food_times.length; // 회전판 길이
        
        while (sum + ((pq.peek().getTime() - time) * length) <= k) {
            int now = pq.poll().getTime();
            sum += (now - time) * length;
            length--;
            time = now;
        }
        
        ArrayList<Food> result = new ArrayList();
        
        while (!pq.isEmpty())
            result.add(pq.poll());
        
        Collections.sort(result, new Comparator<Food>(){
           public int compare(Food f1, Food f2){
               return Integer.compare(f1.getIndex(), f2.getIndex());
           } 
        });
        
        return result.get((int) ((k - sum) % length)).getIndex();
    }
}

class Food implements Comparable<Food>{
    int time;
    int index;
    
    public Food(int time, int index){
        this.time = time;
        this.index = index;
    }
    
    public int getTime(){
        return time;
    }
    
    public int getIndex(){
        return index;
    }
    
    public int compareTo(Food f){
        return Integer.compare(this.time, f.time);
    }
}