import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, result;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][K + 1];
        for(int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();
        result = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
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
                if(arr[nx][ny] == '0' && !visited[nx][ny][destroyed]) {
                    visited[nx][ny][destroyed] = true;
                    q.add(new int[]{nx, ny, cnt + 1, destroyed});
                } else {
                    if(destroyed < K && !visited[nx][ny][destroyed + 1]) {
                        visited[nx][ny][destroyed + 1] = true;
                        q.add(new int[]{nx, ny, cnt + 1, destroyed + 1});
                    }
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}