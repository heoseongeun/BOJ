class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int len = balls.length;
        int[] answer = new int[len];
        int[] arr = new int[4];
        for(int i = 0; i < len; i++) {
            if(startX == balls[i][0]) {
                int x = Math.min(m - startX, startX);
                arr[0] = (int)Math.pow(x * 2, 2) + (int)Math.pow(balls[i][1] - startY, 2);
                if(startY < balls[i][1]) {
                    arr[1] = (int)Math.pow(startY + balls[i][1], 2);
                } else {
                    arr[1] = (int)Math.pow(n - startY + n - balls[i][1], 2);
                }
                answer[i] = Math.min(arr[0], arr[1]);
            } else if(startY == balls[i][1]) {
                int y = Math.min(n - startY, startY);
                arr[0] = (int)Math.pow(balls[i][0] - startX, 2) + (int)Math.pow(y * 2, 2);
                if(startX < balls[i][0]) {
                    arr[1] = (int)Math.pow(startX + balls[i][0], 2);
                } else {
                    arr[1] = (int)Math.pow(m - startX + m - balls[i][0], 2);
                }
                answer[i] = Math.min(arr[0], arr[1]);
            } else {
                arr[0] = (int)Math.pow(m + (m - startX) - balls[i][0], 2) 
                        + (int)Math.pow(balls[i][1] - startY, 2);
                arr[1] = (int)Math.pow(startX + balls[i][0], 2) 
                        + (int)Math.pow(balls[i][1] - startY, 2);
                arr[2] = (int)Math.pow(n + (n - startY) - balls[i][1], 2)
                        + (int)Math.pow(balls[i][0] - startX, 2);
                arr[3] = (int)Math.pow(startY + balls[i][1], 2) 
                        + (int)Math.pow(balls[i][0] - startX, 2);
                int min = arr[0];
                for(int j = 1; j < 4; j++) {
                    if(min > arr[j]) min = arr[j];
                }
                answer[i] = min;
            }
        }
        return answer;
    }
}