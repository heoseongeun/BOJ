import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        while(!input.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input, " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < w; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            bw.write(cnt + "\n");
            input = br.readLine();
        }
        bw.close();
        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
            }
        }
    }
}