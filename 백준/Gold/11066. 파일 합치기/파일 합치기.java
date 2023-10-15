import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] files = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            files[1] = Integer.parseInt(st.nextToken());
            for(int i = 2; i <= n; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                files[i] = tmp + files[i - 1];
            }
            for(int j = 1; j < n; j++) {
                for(int start = 1; start + j <= n; start++) {
                    int end = start + j;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int mid = start; mid < end; mid++)
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][mid] + dp[mid + 1][end] + files[end] - files[start - 1]);
                }
            }
            bw.write(dp[1][n] + "\n");
        }
        br.close();
        bw.close();
    }
}