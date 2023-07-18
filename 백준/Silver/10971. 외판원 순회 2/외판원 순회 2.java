import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long result = Integer.MAX_VALUE;
    static int[][] W;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) W[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i, 0);
        }
        System.out.println(result);
        br.close();
    }

    public static void dfs(int start, int now, long cost) {
        if(check()) {
            if(W[now][start] != 0) result = Math.min(result, cost + W[now][0]);
            return;
        }
        for(int i = 1; i < n; i++) {
            if(!visited[i] && W[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + W[now][i]);
                visited[i] = false;
            }
        }
    }

    public static boolean check() {
        for(int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}