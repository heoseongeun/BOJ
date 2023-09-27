import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] arr;
    static int[][] group;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        group = new int[N][M];
        for(int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();
        int index = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '0' && group[i][j] == 0) {
                    map.put(index, bfs(i, j, index));
                    index++;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(count(i, j) + "");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    static int count(int x, int y) {
        int sum = 1;
        HashSet<Integer> set = new HashSet<>();
        if(arr[x][y] == '0') return 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || group[nx][ny] == 0) continue;
            if(group[nx][ny] == 0) continue;
            if(arr[nx][ny] == '0') set.add(group[nx][ny]);
        }
        for(int i: set) sum += map.get(i);
        return sum % 10;
    }

    static int bfs(int s, int e, int num) {
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, e});
        group[s][e] = num;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(arr[nx][ny] == '0' && group[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    group[nx][ny] = num;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}