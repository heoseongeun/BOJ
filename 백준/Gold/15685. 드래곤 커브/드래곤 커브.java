import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1}; // 우 상 좌 하
    static boolean[][] visited = new boolean[101][101];
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 방향
            int g = Integer.parseInt(st.nextToken()); // 세대
            list = new LinkedList<>();
            addDir(d, g);
            draw(x, y);
        }
        bw.write(check() + "");
        br.close();
        bw.close();
    }

    public static void addDir(int d, int g) {
        list.add(d);
        for(int i = 1; i <= g; i++) {
            for(int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }
    }

    public static void draw(int x, int y) {
        visited[x][y] = true;
        int nx = x, ny = y;
        for(int i = 0; i < list.size(); i++) {
            int d = list.get(i);
            nx += dx[d];
            ny += dy[d];
            visited[nx][ny] = true;
        }
    }

    public static int check() {
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1])
                    cnt++;
            }
        }
        return cnt;
    }
}