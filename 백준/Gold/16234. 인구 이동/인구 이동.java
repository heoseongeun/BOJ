import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, cnt = 0;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<int[]> union = new ArrayList<>();
    static boolean move = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        while(true) {
            move = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) bfs(i, j);
                }
            }
            if(!move) break;
            else cnt++;
        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        union.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int diff = Math.abs(arr[x][y] - arr[nx][ny]);
                    if(!visited[nx][ny] && L <= diff && diff <= R) {
                        move = true;
                        visited[nx][ny] = true;
                        union.add(new int[]{nx, ny});
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        int sum = 0;
        for(int[] tmp: union) sum += arr[tmp[0]][tmp[1]];
        int area = sum / union.size();
        for(int[] tmp: union) arr[tmp[0]][tmp[1]] = area;
        union.removeAll(union);
    }
}