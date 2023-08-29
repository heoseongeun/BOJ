import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static int N, M, K, answer = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0, 0);
        bw.write(answer + "");
        br.close();
        bw.close();
    }

    static void dfs(int x, int y, int idx, int sum) {
        if(idx == K) {
            answer = Math.max(answer, sum);
            return;
        } else {
            for(int i = x; i < N; i++) {
                for(int j = y; j < M; j++) {
                    if(!visited[i][j]) {
                        if(check(i, j)) {
                            visited[i][j] = true;
                            dfs(x, y, idx + 1, sum + arr[i][j]);
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    static boolean check(int x, int y) {
        boolean flag = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(visited[nx][ny]) flag = false;
            }
        }
        return flag;
    }
}