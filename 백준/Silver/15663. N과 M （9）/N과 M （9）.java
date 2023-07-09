import java.io.*;
import java.util.*;

public class Main {
    static int[] result, arr;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int depth) {
        if(depth == m) {
            for(int i: result) sb.append(i + " ");
            sb.append('\n');
            return;
        }
        int before = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i] && before != arr[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                before = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}