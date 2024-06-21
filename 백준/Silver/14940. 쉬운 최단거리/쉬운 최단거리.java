import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int x = 0, y = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    arr[i][j] = 0;
                    x = i;
                    y = j;
                }
            }
        }
        visited = new boolean[n][m];
        bfs(x, y);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) arr[i][j] = -1;
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (visited[nx][ny] || arr[nx][ny] == 0)
                    continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                arr[nx][ny] = arr[now[0]][now[1]] + 1;
            }
        }
    }
}