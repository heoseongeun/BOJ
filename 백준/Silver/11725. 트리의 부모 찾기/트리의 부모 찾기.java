import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        for(int i = 2; i < parent.length; i++) bw.write(parent[i] + "\n");
        bw.close();
        br.close();
    }

    static void dfs(int index) {
        visited[index] = true;
        for(int i: list[index]) {
            if(!visited[i]) {
                parent[i] = index;
                dfs(i);
            }
        }
    }
}