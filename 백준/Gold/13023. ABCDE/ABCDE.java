import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int n, m, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 0; i < n; i++) 
            if(answer == 0) dfs(1, i);
        bw.write(answer + "");
        bw.close();
        br.close();
    }

    static void dfs(int depth, int start) {
        if(depth == 5) {
            answer = 1;
            return;
        }
        visited[start] = true;
        for(int i: list[start]) {
            int next = i;
            if(!visited[next]) dfs(depth + 1, next);
        }
        visited[start] = false;
    }
}