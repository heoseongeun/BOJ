import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result = 0;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }

    static void dfs(int index) {
        if(visited[index]) return;
        else {
            visited[index] = true;
            for(int i = 1; i <= n; i++) {
                if(arr[index][i] == 1) dfs(i);
            }
        }
    }
}