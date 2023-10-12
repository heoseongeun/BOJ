import java.io.*;
import java.util.*;

public class Main {
    static int k, w, h;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < w; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[h][w][k + 1];
        min = bfs();
        if(min == Integer.MAX_VALUE) bw.write("-1");
        else bw.write(min + "");
        br.close();
        bw.close();
    }

    static int bfs() {
        Queue<Monkey> q = new LinkedList<>();
        q.add(new Monkey(0, 0, 0, k));
        visited[0][0][k] = true;
        while(!q.isEmpty()) {
            Monkey cur = q.poll();
            if(cur.x == h - 1 && cur.y == w - 1) return cur.cnt;
            for(int i = 0; i < 4; i ++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < h && ny < w
                        && !visited[nx][ny][cur.k] && arr[nx][ny] == 0) {
                    visited[nx][ny][cur.k] = true;
                    q.add(new Monkey(nx, ny, cur.cnt + 1, cur.k));
                }
            }
            if(cur.k > 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = cur.x + hdx[i];
                    int ny = cur.y + hdy[i];
                    if(nx >= 0 && ny >= 0 && nx < h && ny < w
                            && !visited[nx][ny][cur.k - 1] && arr[nx][ny] == 0) {
                        visited[nx][ny][cur.k - 1] = true;
                        q.add(new Monkey(nx, ny, cur.cnt + 1, cur.k - 1));
                    }
                }
            }
        }
        return min;
    }

    static class Monkey {
        int x;
        int y;
        int cnt;
        int k;

        public Monkey(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }
}