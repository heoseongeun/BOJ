import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        int[][] arr = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = INF;
        for(int color = 0; color < 3; color++) {
            for(int i = 0; i < 3; i++) {
                if(i == color) dp[1][i] = arr[1][i];
                else dp[1][i] = INF;
            }
            for(int i = 2; i <= n; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            for(int i = 0; i < 3; i++) {
                if(i != color) ans = Math.min(ans, dp[n][i]);
            }
        }
        bw.write("" + ans);
        bw.flush();
        bw.close();
        br.close();
    }
}