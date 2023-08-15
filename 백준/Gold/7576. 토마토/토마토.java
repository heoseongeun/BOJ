import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1}; // 하, 상, 우, 좌
    static int[] dy = {1, -1, 0, 0};
    static int n, m, cnt = 0;
    static int[][] arr;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) q.add(new int[]{i, j});
            }
        }
        bw.write(bfs() + "");
        bw.close();
        br.close();
    }

    static int bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    arr[nx][ny] = arr[x][y] + 1;
                }
            }
            cnt++;
        }

        int max = Integer.MIN_VALUE;
        if(check()) return -1;
        else {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(max < arr[i][j]) max = arr[i][j];
                }
            }
        }
        return max - 1;
    }

    static boolean check() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) return true;
            }
        }
        return false;
    }
}