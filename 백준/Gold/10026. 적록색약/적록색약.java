import java.io.*;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) arr[i][j] = s.charAt(j);
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        bw.write(cnt + " ");
        cnt = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        char c = arr[x][y];
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(!visited[nx][ny] && arr[nx][ny] == c) dfs(nx, ny);
        }
    }
}