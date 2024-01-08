import java.util.*;

class Solution {
    static int[][] oil;
    static int n, m;
    static boolean[][] check;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int solution(int[][] land) {
        int answer = 0, idx = 0;    
        n = land.length;
        m = land[0].length;
        check = new boolean[n][m];
        oil = new int[n][m];
        Map<Integer, Integer> oilSize = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !check[i][j]) {
                    int size = bfs(i, j, idx, land);
                    oilSize.put(idx, size);
                    idx++;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(land[j][i] == 1) set.add(oil[j][i]);
            }
            for(int id: set) sum += oilSize.get(id);
            answer = Math.max(sum, answer);
        }
        return answer;
    }
    
    static int bfs(int x, int y, int id, int[][] land) {
        int result = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        check[x][y] = true;
        oil[x][y] = id;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m 
                   && land[nx][ny] == 1 && !check[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    check[nx][ny] = true;
                    oil[nx][ny] = id;
                    result++;
                }
            }
        }
        return result;
    }
}