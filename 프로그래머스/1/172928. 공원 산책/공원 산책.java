import java.util.*;

class Solution {
    static char[][] g;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Map<String, Integer> map = new HashMap();
    static int x;
    static int y;
    
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        g = new char[n][];
        
        for (int i = 0; i< n; i++){
            g[i] = park[i].toCharArray();
        }
        
        int m = g[0].length;
        
        for (int i = 0; i< n; i++){
            for (int j = 0; j < m; j++){
                if (g[i][j] == 'S'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        
        for (char[] a : g){
            //System.out.println(Arrays.toString(a));
        }
        
        mapInit();
        boolean flag = false;
        
        for (String s : routes){
            String direction = String.valueOf(s.charAt(0));
            int move = s.charAt(2) - '0';
            
            int index = map.get(direction);
            int temp_x = x;
            int temp_y = y;
            
            for (int i = 0; i< move; i++){
                flag = false;
                int nx = temp_x + dx[index];
                int ny = temp_y + dy[index];
            
                if (nx < 0 || nx >=n || ny < 0 || ny>=m){
                    flag = true;
                    System.out.println("1" + direction);
                    break;
                }
                    
                if (g[nx][ny] == 'X'){
                    flag = true;
                    System.out.println("2" + direction);
                    break;
                }
                
                temp_x = nx;
                temp_y = ny;
            }
            
            if (flag)
                continue;
            
            x = temp_x;
            y = temp_y;
        }
        return new int[]{x, y};
    }
    
    static void mapInit(){
        map.put("N", 0);
        map.put("S", 1);
        map.put("W", 2);
        map.put("E", 3);
    }
}