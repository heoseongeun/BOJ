import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) max = Math.max(max, bfs(i, j));
            }
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, 0));
        visited = new boolean[n][m];
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            for(int i = 0; i < 8; i ++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if(arr[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new Pos(nx, ny, cur.cnt + 1));
                    } else return cur.cnt + 1;
                }
            }
        }
        return -1;
    }

    static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}