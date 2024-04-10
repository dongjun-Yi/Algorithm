import java.util.*;

class Solution {
    
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        int[][] board = new int[n*3][n*3];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i+n][j+n] = lock[i][j];
            }
        }
        
        for (int i = 1; i< n*2; i++){
            for(int j = 1; j < n*2; j++){
                for (int k = 0; k < 4; k++){
                    key = rotateKey(key);
                    
                    for (int x = 0; x < m; x++){
                        for (int y = 0; y < m; y++){
                            board[x + i][y + j] += key[x][y];
                        }
                    }
                    
                    if (check(board)){
                        return true;
                    }
                    
                    for (int x = 0; x < m; x++){
                        for (int y = 0; y < m; y++){
                            board[x + i][y + j] -= key[x][y];
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static boolean check(int[][] board) {
        int lockLength = (board.length) / 3;
        for (int i = lockLength; i < lockLength * 2; i++){
            for (int j =lockLength; j < lockLength * 2; j++){
                if (board[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
    
    static int[][] rotateKey(int[][] key){
        int n = key.length;
        int m = key[0].length;
        int[][] result = new int[m][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                result[j][n-1-i] = key[i][j];
            }
        }
        
        return result;
    }
}