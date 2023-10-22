import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;
        for(int i = 1; i < N - 1; i++) {
            for(int num = 0; num <= 20; num++) {
                if (num - arr[i] >= 0) dp[i][num] += dp[i - 1][num - arr[i]];
                if (num + arr[i] <= 20) dp[i][num]+=dp[i - 1][num + arr[i]];
            }
        }
        bw.write(dp[N - 2][arr[N - 1]] + "");
        br.close();
        bw.close();
    }
}