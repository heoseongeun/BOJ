import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];
        for(int i = 1; i <= Math.min(N, 6); i++) dp[i] = i;
        for(int i = 7; i <= N; i++) {
            for(int j = 2; j <= 5; j++) dp[i] = Math.max(dp[i - (j + 1)] * j, dp[i]);
        }
        bw.write(dp[N] + "");
        br.close();
        bw.close();
    }
}