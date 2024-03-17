class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
    
    void quad(int[][] arr, int x, int y, int length) {
        if(zip(arr, x, y, length, arr[x][y])){
            if(arr[x][y] == 1) answer[1]++;
            else answer[0]++;
            return;
        }
        quad(arr, x, y, length / 2);
        quad(arr, x + length / 2, y, length / 2);
        quad(arr, x, y + length / 2, length / 2);
        quad(arr, x + length / 2, y + length / 2, length / 2);
    }
    
    boolean zip(int[][] arr, int x, int y, int length, int num) {
        for(int i = x; i < x + length; i++){
            for(int j = y; j < y + length; j++){
                if(arr[i][j] != num) return false;
            }
        }
        return true;
    }
}