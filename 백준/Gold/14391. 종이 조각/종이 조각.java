import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m, answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) arr[i][j] = s.charAt(j) - '0';
        }
        dfs(0, 0, 0);
        bw.write(answer + "");
        bw.close();
        br.close();
    }

    static void dfs(int depth, int num, int sum) {
        if(depth == n * m) {
            answer = Math.max(sum, answer);
            return;
        }
        int row = depth / m;
        int col = depth % m;
        if(visited[row][col]) dfs(depth + 1, num, sum);
        else {
            visited[row][col] = true;
            num += arr[row][col];
            dfs(depth + 1, 0, sum + num);
            // 세로
            int i, tmp = num;
            for(i = row + 1; i < n; i++) {
                if(visited[i][col]) break;
                visited[i][col] = true;
                tmp = tmp * 10 + arr[i][col];
                dfs(depth + 1, 0, sum + tmp);
            }
            for(int j = row + 1; j < i; j++) visited[j][col] = false;
            // 가로
            tmp = num;
            for(i = col + 1; i < m; i++) {
                if(visited[row][i]) break;
                visited[row][i] = true;
                tmp = tmp * 10 + arr[row][i];
                dfs(depth + i - col + 1, 0, sum + tmp);
            }
            for(int j = col + 1; j < i; j++) visited[row][j] = false;
            visited[row][col] = false;
        }
    }
}