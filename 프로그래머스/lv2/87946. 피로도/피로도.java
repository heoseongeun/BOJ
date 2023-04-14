// import java.util.*;
// import java.io.*;

class Solution {
    static boolean visited[];
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);
        return answer;
    }
    
    public static void dfs(int[][] dungeons, int cnt, int k) {
        answer = Math.max(answer, cnt);
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dungeons, cnt + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}