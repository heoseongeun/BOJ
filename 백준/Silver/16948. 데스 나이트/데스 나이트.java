import java.io.*;
import java.util.*;

public class Main {
    static int N, r1, c1, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        bfs();
        br.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1, c1, 0});
        visited[r1][c1] = true;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i = 0; i < 6; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(nx < 0 || ny < 0 || nx > N || ny > N || visited[nx][ny]) continue;
                if(nx == r2 && ny == c2) {
                    System.out.println(tmp[2] + 1);
                    System.exit(0);
                }
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, tmp[2] + 1});
            }
        }
        System.out.println(-1);
    }
}