import java.util.*;

class Solution {
    private int count = -1;
    private boolean visited[][];
    private int n, m;
    private int dx[] = new int[]{-1, 1, 0, 0};
    private int dy[] = new int[]{0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(maps, 0, 0);
    }
    
    public int bfs(int[][] maps, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 1});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            x = tmp[0];
            y = tmp[1];
            int cnt = tmp[2];
            if(x == n - 1 && y == m - 1) {
                count = cnt;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return count;
    }
}