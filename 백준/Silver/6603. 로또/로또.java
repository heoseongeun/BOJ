import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            arr = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int depth, int start) {
        if(depth == 6) {
            for(int i = 0; i < n; i++) {
                if(visited[i]) sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}