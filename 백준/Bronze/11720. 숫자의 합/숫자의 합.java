import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String s = sc.next();
        char[] chars = s.toCharArray();
        int sum = 0;
        
        for(int i = 0; i< n; i++){
            sum += chars[i] - 48;
        }
        
        System.out.println(sum);
    }
}