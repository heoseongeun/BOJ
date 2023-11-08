import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] parents;
    static int[][] arr;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        parents = new int[R * C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                parents[i * C + j] = i * C + j;
            }
        }
        bw.write(solve());
        br.close();
        bw.close();
    }

    static String solve() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(parents[i * C + j] == i * C + j) dfs(i, j);
            }
        }
        int[] ans = new int[R * C];
        for(int i = 0; i < R * C; i++) ans[find(i)]++;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) sb.append(ans[i * C + j] + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    static void dfs(int x, int y) {
        int min = arr[x][y];
        int minX = 0, minY = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny) && min > arr[nx][ny]) {
                min = arr[nx][ny];
                minX = nx;
                minY = ny;
            }
        }
        if(min < arr[x][y]) {
            parents[x * C + y] = minX * C + minY;
            if(parents[minX * C + minY] == minX * C + minY) dfs(minX, minY);
        }
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean check(int x, int y) {
        if(x >= 0 && x < R && y >= 0 && y < C) return true;
        return false;
    }
}