import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(max + "");
        br.close();
        bw.close();
    }

    static void dfs(int n) {
        if(n == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(n + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = arr[i][j];
                if(map[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
}