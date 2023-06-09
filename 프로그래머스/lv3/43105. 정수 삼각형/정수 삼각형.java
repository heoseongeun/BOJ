import java.util.*;

class Solution {
    private Integer dp[][];
    public int solution(int[][] triangle) {
        int n = triangle.length;
        dp = new Integer[n][n];
		for (int i = 0; i < dp.length; i++) {	
			dp[dp.length - 1][i] = triangle[n - 1][i];
		}
		int answer = DFS(triangle, 0, 0);
		return answer;
    }
    private int DFS(int[][] triangle, int depth, int idx) {
		if (depth == dp.length - 1) return dp[depth][idx];
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(DFS(triangle, depth + 1, idx), 
                                      DFS(triangle, depth + 1, idx + 1))
					+ triangle[depth][idx];	
		}
		return dp[depth][idx];
	}
}