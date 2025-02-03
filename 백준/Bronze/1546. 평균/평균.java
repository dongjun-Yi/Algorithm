import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        
        for (int i =0; i < n; i++){
            numbers[i] = sc.nextInt();
        }
        
        double result = 0;
        
        Arrays.sort(numbers);
        int m = numbers[n -1];
        
        for (int i =0; i < n; i++){
            result += (double) numbers[i] / m * 100;
        }
        
        System.out.println(result / n);
    }
}