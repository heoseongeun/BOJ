import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][M + 1];
        int[][] arr = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) 
                dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j], arr[i][j] + dp[i][j - 1]);
        }
        bw.write(dp[N][M] + "");
        br.close();
        bw.close();
    }
}