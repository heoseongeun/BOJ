import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int[] aparts = new int[25 * 25];
    static int n, num = 0;
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) arr[i][j] = s.charAt(j) - '0';
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    num++;
                    dfs(i, j);
                }
            }
        }
        Arrays.sort(aparts);
        System.out.println(num);
        for(int i = 0; i < aparts.length; i++) {
            if(aparts[i] != 0) System.out.println(aparts[i]);
        }
        bw.close();
        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        aparts[num]++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(arr[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
            }
        }
    }
}