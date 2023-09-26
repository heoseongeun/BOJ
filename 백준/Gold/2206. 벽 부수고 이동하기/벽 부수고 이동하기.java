import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) arr[i][j] = s.charAt(j) - '0';
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int result = -1;
        boolean[][][] visited = new boolean[N][M][2];
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int destroyed = now[3];
            if(x == N - 1 && y == M - 1) {
                result = cnt;
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                int ncnt = cnt + 1;
                if(arr[nx][ny] == 0) {
                    if(destroyed == 0 && !visited[nx][ny][0]) {
                        q.add(new int[]{nx, ny, ncnt, 0});
                        visited[nx][ny][0] = true;
                    } else if(destroyed == 1 && !visited[nx][ny][1]) {
                        q.add(new int[]{nx, ny, ncnt, 1});
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if(destroyed == 0) {
                        q.add(new int[]{nx, ny, ncnt, 1});
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}