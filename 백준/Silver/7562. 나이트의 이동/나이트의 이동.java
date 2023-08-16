import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 1, -1, -1, -2, -2, 2, 2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int[] start = new int[2], end = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            if(start[0] == end[0] && start[1] == end[1]) bw.write(0 + "\n");
            else {
                bfs(start[0], start[1]);
                bw.write(arr[end[0]][end[1]] + "\n");
            }
        }
        bw.close();
        br.close();
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[a][b] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(!visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        arr[nx][ny] = arr[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                    if(nx == end[0] && ny == end[1]) return;
                }
            }
        }
    }
}