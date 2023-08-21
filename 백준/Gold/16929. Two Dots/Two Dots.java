import java.io.*;
import java.util.*;

public class Main {
    static int n, m, firstX, firstY;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) arr[i][j] = s.charAt(j);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                firstX = i;
                firstY = j;
                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
        bw.close();
        br.close();
    }

    static boolean dfs(int x, int y, int cnt) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[x][y] == arr[nx][ny]) {
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(dfs(nx, ny, cnt + 1)) return true;
                } else {
                    if(cnt >= 4 && firstX == nx && firstY == ny) return true;
                }
            }
        }
        return false;
    }   
}