class Solution {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    public int solution(int[][] board) {
        int n = board.length, m = board[0].length;
        int answer = n * m;
        boolean[][] check = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1) {
                    if(!check[i][j]) {
                        check[i][j] = true;
                        answer--;
                    }
                    for(int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            if(!check[nx][ny]) {
                                check[nx][ny] = true;
                                answer--;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}