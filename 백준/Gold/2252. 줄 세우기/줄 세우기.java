import java.io.*;
import java.util.*;

public class Main {
    static int H, W, N;
    static ArrayList<int[]> list = new ArrayList<>();
    static ArrayList<int[]> tmp = new ArrayList<>();
    static boolean[] visited = new boolean[100];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N + 1; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            count[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N + 1; i++) {
            if(count[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int n = q.poll();
            bw.write(n + " ");
            List<Integer> list = graph.get(n);
            for(int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                count[tmp]--;
                if(count[tmp] == 0) q.offer(tmp);
            }
        }
        br.close();
        bw.close();
    }
}