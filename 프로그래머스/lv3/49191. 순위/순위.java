import java.util.*;

class Solution {
    static final int INF = 987654321;
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) 
            Arrays.fill(map[i], INF);

        for (int i = 0; i < results.length; i++) 
            map[results[i][0]][results[i][1]] = 1;

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (map[i][j] != INF || map[j][i] != INF) cnt++;
            }
            if (cnt == n - 1) answer++;
        }
        
        return answer;
    }
}