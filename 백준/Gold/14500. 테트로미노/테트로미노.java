import java.io.*;
import java.util.*;

public class Main {
    private static int n, m, result, arr[][];
    private static boolean check[][];
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {-1, 1, 0, 0};
    private static int ex[][] = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
    private static int ey[][] = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        check = new boolean[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++) check[i][j] = false;
        }
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                check[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                check[i][j] = false;
                check_exshape(i, j);
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, int sum_value, int length) {
        if (length >= 4) {
            result = Math.max(result, sum_value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if (check[nx][ny] == false) {
                check[nx][ny] = true;
                dfs(nx, ny, sum_value + arr[nx][ny], length + 1);
                check[nx][ny] = false;
            }
        }
    }

    public static void check_exshape(int x, int y) {
        for (int i = 0; i < 4; i++) {
            boolean isOut = false;
            int sum_value = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + ex[i][j];
                int ny = y + ey[i][j];
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    isOut = true;
                    break;
                } else sum_value += arr[nx][ny];
            }
            if (!isOut) result = Math.max(result, sum_value);
        }
    }
}