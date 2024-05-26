import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static int N, M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = 0;
        dist = new int[N + 1];
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijst();
        bw.write(dist[N] + "");
        bw.flush();
    }

    static void dijst() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(1, 0));
        dist[1] = 0;
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(Node next: graph.get(now.v)) {
                if(dist[next.v] > dist[now.v] + next.cost) {
                    dist[next.v] = dist[now.v] + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    static class Node {
        int v;
        int cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}