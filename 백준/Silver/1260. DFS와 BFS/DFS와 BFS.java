import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static int n, m, v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for(int i = 1; i <= n; i++) {
            if(arr[start][i] == 1 && !visited[i]) dfs(i);
        }
    }

    static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");
            for(int i = 1; i <= n; i++) {
                if(arr[start][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}