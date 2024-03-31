class Solution {
    public int solution(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) dp[i][0] = board[i][0];
        for(int j = 0; j < board[0].length; j++) dp[0][j] = board[0][j];
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 1; j < dp[0].length; j++) {
        		if(board[i][j] != 1) continue;
        		int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
        		min = Math.min(min,dp[i - 1][j - 1]);
        		dp[i][j] = min + 1;
        	}
        }
        int max = -1;
        for(int i = 0; i < dp.length; i++) {
        	for(int j = 0; j < dp[0].length; j++) {
        		max = Math.max(max, dp[i][j] * dp[i][j]);
        	}
        }
        return max;
    }
}