import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N + 1];
        long[] dp = new long[1101];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        for(int i = 1; i <= N; i++) {
            if(dp[i] >= Integer.MAX_VALUE) continue;
            for(int j = 1; j <= arr[i]; j++)
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
        }
        if(dp[N] >= Integer.MAX_VALUE) bw.write("-1");
        else bw.write(dp[N] + "");
        br.close();
        bw.close();
    }
}