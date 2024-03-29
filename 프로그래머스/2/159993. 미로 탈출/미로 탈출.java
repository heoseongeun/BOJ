import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] arr;
    static boolean[][] visited;
    static int x, y, lX, lY, eX, eY, n, m, answer = 0;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        arr = new char[n][m];
        for(int i = 0; i < n; i++) { // 초기 설정
            for(int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                arr[i][j] = c;
                if(c == 'S') {
                    x = i;
                    y = j;
                } else if(c == 'L') {
                    lX = i;
                    lY = j;
                } else if(c == 'E') {
                    eX = i;
                    eY = j;
                }
            }
        }
        bfs(lX, lY);
        if(answer == -1) return answer;
        bfs(eX, eY);
        return answer;
    }
    
    void bfs(int tX, int tY) {
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                  && arr[nx][ny] != 'X' && !visited[nx][ny]) {
                    if(nx == tX && ny == tY) {
                        answer += now[2] + 1;
                        x = nx;
                        y = ny;
                        return;
                    }
                    q.add(new int[]{nx, ny, now[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        answer = -1;
        return;
    }
}