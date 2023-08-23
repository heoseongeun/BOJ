import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int x;
    int y;
    int wall;

    public Node(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall;
    }

    @Override
    public int compareTo(Node o) {
        return this.wall - o.wall;
    }
}

public class Main {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) arr[i][j] = s.charAt(j) - '0';
        }
        bw.write(bfs() + "");
        bw.close();
        br.close();
    }

    static int bfs() {
        Queue<Node> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;
        q.add(new Node(0, 0, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            int wall = now.wall;
            if(x == N - 1 && y == M - 1) return wall;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if(arr[ny][nx] == 0) q.add(new Node(nx, ny, wall));
                    else q.add(new Node(nx, ny, wall + 1));
                }
            }
        }
        return 0;
    }
}