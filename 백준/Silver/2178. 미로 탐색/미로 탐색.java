import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}; // 하, 상, 우, 좌
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) arr[i][j] = s.charAt(j) - '0';
        }
        bfs();
        bw.write(arr[n - 1][m - 1] + "");
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1) {
                    if(arr[nx][ny] != 1) arr[nx][ny] = Math.min(arr[x][y] + 1, arr[nx][ny]);
                    else arr[nx][ny] = arr[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}